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

    private Stack<Bullet> bulletPool;
    private HashMap<Integer, Bullet> bulletHashMap;
    private HashMap<Integer, Zombie> zombieHashMap;
    private Player player;
    int zombieCount = 0;
    int bulletCount = 0;
    private final int ZOMBIESPEED = 50;

    public ObjectManager(TextureManager textureManager, Stage stage){

        this.textureManager = textureManager;
        this.stage = stage;

        bulletPool = new Stack<>();
        bulletHashMap = new HashMap<>();
        zombieHashMap = new HashMap<>();

    }

    public void update(){
        for(Zombie cZombie : zombieHashMap.values()){
            cZombie.updatePlayerPosition(player.getPosition());
        }
    }

    public void checkCollision(){

        for(Zombie cZombie :  zombieHashMap.values()){

            for(Bullet cBullet : bulletHashMap.values()){
                float cX = Math.abs(cBullet.getX() - cZombie.getX());
                float cY = Math.abs(cBullet.getY() - cZombie.getY());
                if(cX > 0 && cX < 30 && cY > 0 && cY < 30){
                    cZombie.takeDamage();
                    cBullet.takeDamage();
                }
            }
        }

    }

    //[-----------------------------------]
    //[----------Adding Objects-----------]
    //[-----------------------------------]


    public void addPlayer(){
        player = new Player(textureManager.getPlayer(), 100,100, 0);
        stage.addActor(player);
    }

    public void addZombie(int x, int y){
        Zombie newZombie = new Zombie(textureManager.getZombie(), ZOMBIESPEED, new Vector2(0,0), x,y, zombieCount);
        stage.addActor(newZombie);
        zombieHashMap.put(zombieCount, newZombie);
        zombieCount ++;
    }

    public Bullet addBullet(){
        Bullet bullet;
        if(bulletPool.isEmpty()) bulletPool.push(new Bullet(textureManager.getBullet(), bulletCount, this));

        bullet = bulletPool.pop();
        stage.addActor(bullet);
        bulletHashMap.put(bullet.getId(), bullet);
        bulletCount ++;
        return bullet;
    }

    public void changeFromMapToPool(int id){

        bulletPool.push(bulletHashMap.get(id));
        bulletHashMap.remove(id);

    }

    public Player getPlayer() {
        return player;
    }

}
