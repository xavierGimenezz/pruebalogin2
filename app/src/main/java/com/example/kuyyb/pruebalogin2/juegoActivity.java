package com.example.kuyyb.pruebalogin2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by kuyyb on 25/05/2016.
 */
public class juegoActivity extends Activity {
    Random rand = new Random();
    int dado = 0;
    TextView dadu;
    Button dados;
    MediaPlayer player;
    CheckBox checkBox3;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablero);
        player = MediaPlayer.create(juegoActivity.this, R.raw.cytus);
        player.setLooping(true);
        player.start();
        dados=(Button)findViewById(R.id.dados);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        //= MediaPlayer.create(this, R.raw.cytus);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox3 .isChecked()){
                    // mediaplayer is already muted, so needs be to unmuted
                    player.pause();
                }else{
                    // mute media player
                    player.start();
                }
            }
        });
        dados.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dado = rand.nextInt(6);
                dado++;
                dadu =(TextView)findViewById(R.id.dadu);
                dadu.setText(""+dado);
            }
        });


    }
    @Override
    protected void onPause(){

        super.onPause();

        player.stop();
    }
    @Override
    protected void onResume(){
        super.onResume();
        player.start();
    }
}