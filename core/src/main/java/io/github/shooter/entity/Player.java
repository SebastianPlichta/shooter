package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import io.github.shooter.managers.ObjectManager;

public class Player extends Entity {

    private Vector2 velocity;
    float dx;
    float dy;
    float angleDegrees;

    public Player(Texture texture, int x, int y, int id){
        super(texture, 100, new Vector2(0,0), id);
        setX(x);
        setY(y);
    }

    @Override
    public void act(float delta) {

        super.act(delta);

        float angle = MathUtils.atan2(dy, dx);
        angleDegrees = angle * MathUtils.radiansToDegrees;
        setRotation(angleDegrees);

    }

    public void updateMousePos(Vector3 mousePos){

        dx = mousePos.x - getX();
        dy = mousePos.y - getY();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void shot(ObjectManager objectManager){

        Bullet bullet = objectManager.addBullet();
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        bullet.setRotation(angleDegrees);
        bullet.shoot(objectManager.getPlayer().getX(),objectManager.getPlayer().getY(),new Vector2(dx/length,dy/length));
    }

    public Vector2 getVelocity() {
        return velocity;
    }


}
