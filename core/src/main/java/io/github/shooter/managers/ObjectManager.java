package io.github.shooter.managers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.shooter.entity.Bullet;
import io.github.shooter.entity.Player;
import io.github.shooter.entity.Zombie;

import java.util.*;

public class ObjectManager {

    private TextureManager textureManager;
    private Stage stage;
    private HashMap<Integer, Bullet> bulletHashMap;
    private HashMap<Integer, Zombie> zombieHashMap;
    private Player player;
    int zombieCount = 0;
    int bulletCount = 0;

    public ObjectManager(TextureManager textureManager, Stage stage){

        this.textureManager = textureManager;
        this.stage = stage;

        bulletHashMap = new HashMap<>();
        zombieHashMap = new HashMap<>();

    }

    public void checkCollision(){

        List<Integer> zombieToRemove = new ArrayList<>();
        List<Integer> bulletToRemove = new ArrayList<>();

        for(Zombie cZombie :  zombieHashMap.values()){

            for(Bullet cBullet : bulletHashMap.values()){
                float cX = Math.abs(cBullet.getX() - cZombie.getX());
                float cY = Math.abs(cBullet.getY() - cZombie.getY());
                if(cX > 0 && cX < 30 && cY > 0 && cY < 30){
                    zombieToRemove.add(cZombie.getId());
                    bulletToRemove.add(cBullet.getId());
                    cZombie.takeDamage();

                    cBullet.takeDamage();
                }
            }
        }

        for(int dB : bulletToRemove){
            bulletHashMap.remove(dB);
        }
        for(int dZ : zombieToRemove){
            zombieHashMap.remove(dZ);
        }

    }

    //[-----------------------------------]
    //[----------Adding Objects-----------]
    //[-----------------------------------]


    public void addPlayer(){
        player = new Player(textureManager.getPlayer(), 100,100, 0);
        stage.addActor(player);
    }

    public void addZombie(){
        Zombie newZombie = new Zombie(textureManager.getZombie(), 100, new Vector2(0,0), 200,50, zombieCount);
        stage.addActor(newZombie);
        zombieHashMap.put(zombieCount, newZombie);
        zombieCount ++;
    }

    public Bullet addBullet(){
        Bullet bullet = new Bullet(textureManager.getBullet(), bulletCount);
        stage.addActor(bullet);
        bulletHashMap.put(bulletCount, bullet);
        bulletCount ++;
        return bullet;
    }

    public Player getPlayer() {
        return player;
    }
}
