package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PantallaJuego extends BaseScreen {

    PantallaJuego(MyGdxGame game) {
        super(game);
    }

    SpriteBatch spriteBatch;
    Texture background, ballonRed, ballonGreen, ballonBlue;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();

        background = new Texture("background.png");
        ballonRed = new Texture("ballon_red.png");
        ballonGreen = new Texture("ballon_green.png");
        ballonBlue = new Texture("ballon_blue.png");
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, 640, 480);

        spriteBatch.draw(ballonRed, 60, 60);
        spriteBatch.draw(ballonGreen, 120, 160);
        spriteBatch.draw(ballonBlue, 160, 260);

        spriteBatch.draw(ballonRed, 360, 60, 100, 100);
        spriteBatch.draw(ballonGreen, 460, 160, 80, 80);
        spriteBatch.draw(ballonBlue, 260, 260, 140, 140);

        spriteBatch.end();
    }
}