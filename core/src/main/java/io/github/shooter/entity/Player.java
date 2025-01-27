package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends Actor {

    private Stage stage;
    private Texture texture;
    private Vector2 velocity;

    public Player(Stage stage, Texture texture, int x, int y){
        this.stage = stage;
        this.texture = texture;
        setX(x);
        setY(y);

        stage.addActor(this);
        velocity = new Vector2(0,0);
    }

    @Override
    public void act(float delta) {
        setX(getX() + velocity.x);
        setY(getY() + velocity.y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,getX(),getY());
    }

    public void dispose(){
        texture.dispose();
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(float x, float y) {
        this.velocity.x = x;
        this.velocity.y = y;
    }
}
