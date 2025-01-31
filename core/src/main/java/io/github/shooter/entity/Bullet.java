package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import io.github.shooter.managers.ObjectManager;

public class Bullet extends Entity {

    float lifeTime;
    private ObjectManager objectManager;

    public Bullet(Texture texture, int id, ObjectManager objectManager){
        super(texture,50,new Vector2(0,0), id);
        lifeTime = 2;
        this.objectManager = objectManager;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        lifeTime -= delta;
        if(lifeTime <= 0){
            objectManager.changeFromMapToPool(getId());
            remove();
        }
    }

    public void shoot(float x, float y, Vector2 velocity){
        lifeTime = 2;
        setX(x);
        setY(y);
        this.velocity = velocity;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
}
