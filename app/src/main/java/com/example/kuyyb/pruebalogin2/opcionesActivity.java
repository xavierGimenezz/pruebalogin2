package com.example.kuyyb.pruebalogin2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by kuyyb on 28/04/2016.
 */
public class opcionesActivity extends Activity {
    CheckBox checkBox;
    MediaPlayer player;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcionacas);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        //= MediaPlayer.create(this, R.raw.cytus);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox .isChecked()){
                    // mediaplayer is already muted, so needs be to unmuted
                    player.setVolume(1,1);
                }else{
                    // mute media player
                    player.setVolume(0,0);
                }
            }
        });
    }
}