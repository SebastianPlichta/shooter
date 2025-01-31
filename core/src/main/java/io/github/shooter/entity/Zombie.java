package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Zombie extends Entity{

    private float dx;
    private float dy;
    private float angleDegrees;

    public Zombie(Texture texture, int speed, Vector2 velocity, int x, int y, int id) {
        super(texture, speed, velocity, id);
        setX(x);
        setY(y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float angle = MathUtils.atan2(dy, dx);
        angleDegrees = angle * MathUtils.radiansToDegrees;
        setRotation(angleDegrees);
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        setVelocity(dx/length,dy/length);
    }

    public void updatePlayerPosition(Vector2 playerPos){

        dx = playerPos.x - getX();
        dy = playerPos.y - getY();
    }

}
