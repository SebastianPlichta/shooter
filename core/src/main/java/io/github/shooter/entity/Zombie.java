package io.github.shooter.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Zombie extends Entity{


    public Zombie(Texture texture, int speed, Vector2 velocity, int x, int y, int id) {
        super(texture, speed, velocity, id);
        setX(x);
        setY(y);
    }

}
