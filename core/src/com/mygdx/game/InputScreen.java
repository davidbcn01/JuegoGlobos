package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputScreen  extends BaseScreen{
    InputScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            System.out.println("Mouse-left just touched at: " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight()-Gdx.input.getY()));
        }

        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            System.out.println("Mouse-right is touched at: " + Gdx.input.getX() + ":" + (Gdx.graphics.getHeight()-Gdx.input.getY()));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            System.out.println("Key A just pressed");
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            System.out.println("Key S is pressed");
        }
    }
}

