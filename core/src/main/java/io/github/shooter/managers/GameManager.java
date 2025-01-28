package io.github.shooter.managers;

public class GameManager {

    private TextureManager textureManager;

    public GameManager(){

        this.textureManager = new TextureManager();

    }

    public void dispose(){
        textureManager.dispose();
    }

    public TextureManager getTextureManager() {
        return textureManager;
    }
}
