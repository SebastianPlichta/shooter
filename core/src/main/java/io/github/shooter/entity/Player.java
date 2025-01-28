package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;

public class Player extends Entity {

    private Vector2 velocity;

    public Player(Texture texture, int x, int y){
        super(texture, 100, new Vector2(0,0));
        setX(x);
        setY(y);

        this.setOrigin(texture.getWidth()/2, texture.getHeight()/2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public Vector2 getVelocity() {
        return velocity;
    }


}
