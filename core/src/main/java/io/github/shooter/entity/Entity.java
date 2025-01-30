package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {

    protected Texture texture;
    protected int speed;
    protected Vector2 velocity;
    private int hp;
    private boolean visible = true;
    private int id;

    public Entity(Texture texture,int speed, Vector2 velocity, int id){
        this.texture = texture;
        this.speed = speed;
        this.velocity = velocity;
        this.id = id;
        hp = 1;
    }

    @Override
    public void act(float delta) {
        setX(getX()+velocity.x * delta*speed);
        setY(getY()+velocity.y * delta*speed);

        if(hp < 1){
            remove();
        }

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

    public void takeDamage(){
        hp --;
    }

    public int getId() {
        return id;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(visible){
            batch.draw(texture,getX(),getY(), getOriginX(),getOriginY(),texture.getWidth(),texture.getHeight(),getScaleX(),getScaleY(),getRotation(), 0, 0, texture.getWidth(), texture.getHeight(),false,false);
        }
    }
}
