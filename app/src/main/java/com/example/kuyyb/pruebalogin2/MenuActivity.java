package com.example.kuyyb.pruebalogin2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by kuyyb on 21/04/2016.
 */
public class MenuActivity extends Activity{
    Button opciones, start, rank;
    MediaPlayer player;
    CheckBox checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_inicio);
        player = MediaPlayer.create(MenuActivity.this, R.raw.cytus);
        player.setLooping(true);
        player.start();
        start=(Button)findViewById(R.id.start);
        rank=(Button)findViewById(R.id.rank);
        opciones=(Button)findViewById(R.id.opciones);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        //= MediaPlayer.create(this, R.raw.cytus);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox2 .isChecked()){
                    // mediaplayer is already muted, so needs be to unmuted
                    player.pause();
                }else{
                    // mute media player
                    player.start();
                }
            }
        });
        /*opciones.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente3 = new Intent(getApplicationContext(),opcionesActivity.class);
                startActivity(siguiente3);
            }
        });*/
        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente2 = new Intent(getApplicationContext(),juegoActivity.class);
                startActivity(siguiente2);
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
    //public void playmusic();

}
