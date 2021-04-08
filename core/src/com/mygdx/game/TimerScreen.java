package com.mygdx.game;

public class TimerScreen extends BaseScreen{

    float gameTime;
    float alarmTime;
    float alarmDuration = 1;  // 1 segundo

    TimerScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {  // delta = 0.167


        gameTime += delta;
        System.out.println(gameTime);

        if(gameTime > alarmTime){
            alarmTime = gameTime + alarmDuration;
//            System.out.println("Alarm");
        }
    }
}
