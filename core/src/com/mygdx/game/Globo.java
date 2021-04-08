package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Globo {

    enum Color {ROJO, VERDE, AZUL}
    Random r = new Random();
    static Texture globoRed = new Texture("ballon_red.png");
    static Texture globoGreen = new Texture("ballon_green.png");
    static Texture globoBlue = new Texture("ballon_blue.png");
    float x, y, size;
    float vx, vy;
    Color color;
    boolean borrar = false;

    float alarmaDireccion = 1;


    public Globo() {
        x = getRandomX();
        y = -50;
        size = getRandomSize();
        vx = getRandomVX();
        vy = getRandomVY();
        color = getRandomColor();
    }

    public Globo(float morespeed) {
        x = getRandomX();
        y = -50;
        size = getRandomSize();
        vx = getRandomVX();
        vy = getRandomVY()+morespeed;
        color = getRandomColor();
    }

    public Color getRandomColor(){
        int a = r.nextInt(3)+1;
        if (a==1){
             return Globo.Color.ROJO;
        }
        if(a==2){
            return Globo.Color.AZUL;
        }
        return Globo.Color.VERDE;
    }

    public float getRandomSize(){
        return r.nextInt(50-20)+20;
    }

    public float getRandomVX(){
        return r.nextInt(40)-20;  //-15 15
    }

    public float getRandomVY(){
        return r.nextInt(30)+5;
    }

    public float getRandomX(){
        return r.nextInt(610-10)+10;
    }


    public void update(float delta) {
        //x += speed * delta;
        y += vy * delta;
    }

    public void movimientoLateral(float gameTime){
     if(gameTime>alarmaDireccion){
         x+=vx;
         alarmaDireccion = gameTime+1;
     }
     vx =getRandomVX();
    }

    public void render(SpriteBatch spriteBatch) {
        Texture texture;
        switch (color) {
            case ROJO:
            default:
                texture = globoRed;
                break;
            case VERDE:
                texture = globoGreen;
                break;
            case AZUL:
                texture = globoBlue;
                break;
        }
        spriteBatch.draw(texture,x-size/2,y-size/2,size,size);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}