package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen extends BaseScreen {

    GameOverScreen(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    BitmapFont bitmapFont;
    Texture fondo;
    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        fondo= new Texture("fondoGameOver.jpg");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.7f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(fondo, 0, 0, 640, 480);
        bitmapFont.getData().setScale(6);
        bitmapFont.setColor(new Color(Color.RED));
        bitmapFont.draw(spriteBatch, "GAME", 200f, 350f);

        bitmapFont.getData().setScale(6);
        bitmapFont.setColor(new Color(Color.RED));
        bitmapFont.draw(spriteBatch, "OVER", 200f, 250f);


        spriteBatch.end();
    }
}