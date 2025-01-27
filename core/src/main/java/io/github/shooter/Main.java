package io.github.shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.shooter.entity.Player;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private OrthographicCamera camera;
    private Stage stage;
    private FitViewport viewport;
    private Player player;

    @Override
    public void create() {

        int width = 320, height = 180;

        camera = new OrthographicCamera(width,height);
        viewport = new FitViewport(width,height, camera);
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        player = new Player(stage,new Texture(Gdx.files.internal("character.png")), 100,100);

        Gdx.graphics.setWindowedMode(1600,900);
    }

    @Override
    public void render() {

        inputHandler();
        update(Gdx.graphics.getDeltaTime());
        draw();
    }

    private void inputHandler(){

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.setVelocity(-1,0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setVelocity(1,0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setVelocity(0,1);
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setVelocity(0,-1);
        } else{
            player.setVelocity(0,0);
        }

    }

    private void update(float deltaTime){
        stage.act();
    }

    private void draw(){
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
    }

    @Override
    public void dispose() {
        player.dispose();
        stage.dispose();
    }
}
