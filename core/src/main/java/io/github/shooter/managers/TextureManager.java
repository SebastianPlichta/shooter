package io.github.shooter.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

    private Texture player;
    private Texture zombie;
    private Texture tile;
    private Texture bullet;

    public TextureManager(){
        player = new Texture(Gdx.files.internal("character.png"));
        zombie = new Texture(Gdx.files.internal("zombie.png"));
        tile = new Texture(Gdx.files.internal("tile.png"));
        bullet = new Texture(Gdx.files.internal("bullet.png"));

    }

    public void dispose(){
        player.dispose();
        zombie.dispose();
        tile.dispose();
        bullet.dispose();
    }

    public Texture getPlayer() {
        return player;
    }

    public Texture getZombie() {
        return zombie;
    }

    public Texture getTile() {
        return tile;
    }

    public Texture getBullet() {
        return bullet;
    }

}
