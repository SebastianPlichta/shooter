package io.github.shooter.managers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.shooter.entity.Bullet;
import io.github.shooter.entity.Player;
import io.github.shooter.entity.Zombie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ObjectManager {

    private TextureManager textureManager;
    private Stage stage;
    private HashSet<Bullet> bulletList;
    private List<Zombie> zombieList;
    private Player player;

    public ObjectManager(TextureManager textureManager, Stage stage){

        this.textureManager = textureManager;
        this.stage = stage;

        bulletList = new HashSet<>();
        zombieList = new ArrayList<>();

    }

    public void addPlayer(){
        player = new Player(textureManager.getPlayer(), 100,100);
        stage.addActor(player);
    }

    public void addZombie(){
        Zombie newZombie = new Zombie(textureManager.getZombie(), 100, new Vector2(0,0), 200,50);
        stage.addActor(newZombie);
        zombieList.add(newZombie);
    }

    public Player getPlayer() {
        return player;
    }
}
