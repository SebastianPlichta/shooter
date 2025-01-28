package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {

    protected Texture texture;
    protected int speed;
    protected Vector2 velocity;

    public Entity(Texture texture,int speed, Vector2 velocity){
        this.texture = texture;
        this.speed = speed;
        this.velocity = velocity;
    }

    @Override
    public void act(float delta) {
        setX(getX()+velocity.x * delta*speed);
        setY(getY()+velocity.y * delta*speed);
    }

    public void setVelocity(float x, float y) {
        this.velocity.x = x;
        this.velocity.y = y;
    }

    public void setVelocityX(int x) {
        this.velocity.x = x;
    }

    public void setVelocityY(int y) {
        this.velocity.y = y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(texture,getX(),getY(), getOriginX(),getOriginY(),texture.getWidth(),texture.getHeight(),getScaleX(),getScaleY(),getRotation(), 0, 0, texture.getWidth(), texture.getHeight(),false,false);
    }
}
