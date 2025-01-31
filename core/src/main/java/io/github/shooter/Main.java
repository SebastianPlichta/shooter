package io.github.shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.github.shooter.entity.Bullet;
import io.github.shooter.entity.Player;
import io.github.shooter.entity.Zombie;
import io.github.shooter.managers.GameManager;
import io.github.shooter.managers.ObjectManager;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private OrthographicCamera camera;
    private Stage stage;
    private FitViewport viewport;

    private GameManager gameManager;
    private ObjectManager objectManager;

    private Batch batch;
    private BitmapFont font;

    private boolean shoot;
    private Vector3 mousePos;

    private float fps;
    private float fpss;
    private float runtime;
    private float timer;

    @Override
    public void create() {

        int width = 320, height = 180;

        camera = new OrthographicCamera(width,height);
        viewport = new FitViewport(width,height, camera);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        gameManager = new GameManager();
        objectManager = new ObjectManager(gameManager.getTextureManager(),stage);

        objectManager.addPlayer();
//        objectManager.addZombie(100,50);
//        objectManager.addZombie(200,200);

        Gdx.graphics.setWindowedMode(1600,900);

        batch = new SpriteBatch();
        font = new BitmapFont();

    }

    @Override
    public void render() {

        inputHandler();
        update(Gdx.graphics.getDeltaTime());
        draw();
    }

    private void inputHandler(){

        boolean none = true;
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            objectManager.getPlayer().setVelocityX(-1);
            none = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            objectManager.getPlayer().setVelocityX(1);
            none = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            objectManager.getPlayer().setVelocityY(1);
            none = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            objectManager.getPlayer().setVelocityY(-1);
            none = false;
        }
        if(none){
            objectManager.getPlayer().setVelocity(0,0);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            System.out.println("runtime: " + runtime);
            System.out.println("average fps: " + fpss/runtime);
            Gdx.app.exit();
        }

        shoot = Gdx.input.isButtonJustPressed(Input.Buttons.LEFT);

        if(shoot){
            objectManager.getPlayer().shot(objectManager);
        }

    }

    private void update(float deltaTime){
        fps = Gdx.graphics.getFramesPerSecond();
        runtime += deltaTime;
        timer += deltaTime;
        if(timer >= 1){
            fpss += fps;
            timer = 0;
        }
        mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePos);

        objectManager.getPlayer().updateMousePos(mousePos);

        objectManager.update();

        objectManager.checkCollision();
        stage.act();
    }

    private void draw(){

        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.draw();

        batch.begin();
        font.draw(batch,Float.toString(fps),20,20);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
    }

    @Override
    public void dispose() {
        gameManager.dispose();
        stage.dispose();
        batch.dispose();
        font.dispose();
    }
}
