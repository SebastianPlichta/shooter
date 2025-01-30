package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends Entity {

    public Bullet(Texture texture){
        super(texture,500,new Vector2(0,0));
    }

    public void shoot(float x, float y, Vector2 velocity){
        setX(x);
        setY(y);
        this.velocity = velocity;
        this.setOrigin(texture.getWidth()/2, texture.getHeight()/2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
}
