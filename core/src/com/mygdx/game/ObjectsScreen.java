package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsScreen extends BaseScreen {



    ObjectsScreen(MyGdxGame game) {
        super(game);
    }

    Random r = new Random();
    SpriteBatch spriteBatch;
    List<Globo> globoList;

    float tiempo;
    float gameTime;
    float alarmMoreBalls = 3;
    float alarmAddDifficult = 5;
    int score = 0;
    float moreSpeed =5;
    Texture background;
    private Texture progress;
    BitmapFont bitmapFont;
    BitmapFont bitmapFont2;
    BitmapFont bitmapFont3;
    Color clickColor;
    String clickTexto;
    String accion;
    @Override
    public void show() {

        spriteBatch = new SpriteBatch();
        globoList = new ArrayList<>();
        globoList.add(new Globo());
        globoList.add(new Globo());
        globoList.add(new Globo());

        background = new Texture("background.png");
        progress = new Texture("progress.png");
        bitmapFont = new BitmapFont();
        bitmapFont2 = new BitmapFont();
        bitmapFont3 = new BitmapFont();
        clickColor = getRandomColor();
        tiempo = 60;
        clickTexto = getRandomText();
        accion = getRandomAction();
    }

    private void update(float delta) {
        tiempo-=0.01f;

        for(Globo globo: globoList){
            globo.update(delta);
        }

        if(gameTime > alarmMoreBalls) {
            globoList.add(new Globo(moreSpeed));

            alarmMoreBalls = gameTime + r.nextInt(2)+0.5f;
        }

        if(gameTime > alarmAddDifficult){
            alarmAddDifficult = gameTime + 5;

            moreSpeed= moreSpeed+5;
        }

        for(Globo globo: globoList) {
            globo.movimientoLateral(gameTime);
        }

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            int mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
            //System.out.println("ghbruigrew");
            for(Globo globo: globoList) {

                //  System.out.println(Gdx.input.getX() + ":" + mouseY + "    " + globo.getX() + ":" + globo.getY());
                if (distancia(Gdx.input.getX(), mouseY, globo.getX(), globo.getY()) < globo.size/2) {

                    globo.borrar = true;
                    if (accion.equals("C")) {

                        if (clickColor == Color.RED && globo.getColor() == Globo.Color.ROJO) {
                            score++;
                            tiempo++;
                        } else if (clickColor == Color.GREEN && globo.getColor() == Globo.Color.VERDE) {
                            score++;
                            tiempo++;
                        } else if (clickColor == Color.BLUE && globo.getColor() == Globo.Color.AZUL) {
                            score++;
                            tiempo++;
                        } else {
                            score--;
                            tiempo -= 3;
                        }
                        clickColor = getRandomColor();
                        clickTexto = getRandomText();
                        accion = getRandomAction();
                        break;
                    }else if(accion.equals("T")){
                        if(clickTexto.equals("VERDE") && globo.getColor() == Globo.Color.VERDE){
                            score++;
                            tiempo++;
                        }else if (clickTexto.equals("ROJO") && globo.getColor() == Globo.Color.ROJO) {
                            score++;
                            tiempo++;
                        } else if (clickTexto.equals("AZUL") && globo.getColor() == Globo.Color.AZUL) {
                            score++;
                            tiempo++;
                        } else {
                            score--;
                            tiempo -= 3;
                        }
                        clickColor = getRandomColor();
                        clickTexto = getRandomText();
                        accion = getRandomAction();
                        break;
                    }
                }
                //break;
            }
        }
        globoList.removeIf(globo -> globo.borrar);

        if(tiempo<=0){
            setScreen(new GameOverScreen(game));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameTime += delta;


        update(delta);


        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, 640, 480);
        for(Globo globo: globoList) globo.render(spriteBatch);

        bitmapFont.setColor(new Color(Color.WHITE));
        bitmapFont.getData().setScale(3);
        bitmapFont.draw(spriteBatch, String.valueOf(score), 550f, 450f);

        bitmapFont2.setColor(new Color(clickColor));
        bitmapFont2.getData().setScale(3);
        bitmapFont2.draw(spriteBatch, clickTexto, 70f, 450f);

        bitmapFont3.setColor(new Color(Color.WHITE));
        bitmapFont3.getData().setScale(3);
        bitmapFont3.draw(spriteBatch, accion, 10f, 450f);

        spriteBatch.draw(progress, 300f, 420f, tiempo,30);
        spriteBatch.end();

    }



    float distancia(float mx, float my, float gx, float gy){

        return (float) Math.sqrt(Math.pow((mx - gx),2) + Math.pow((my-gy),2));
    }
    public Color getRandomColor(){
        int a = r.nextInt(3)+1;
        if (a==1){
            return Color.RED;
        }
        if(a==2){
            return Color.BLUE;
        }
        return Color.GREEN;
    }
    public String getRandomText(){
        int a = r.nextInt(3)+1;
        if (a==1){
            String text = "ROJO";
            return text;
        }
        if(a==2){
            String text = "AZUL";
            return text;
        }
        String text = "VERDE";
        return text;

    }
    public String getRandomAction(){
        int a = r.nextInt(2)+1;
        if (a==1){
            String text = "T";
            return text;
        }
        String text = "C";
        return text;

    }

}