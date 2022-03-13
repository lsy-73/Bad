package com.example.bad;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.bad);
        //获取手机扬声器，把音量拉到最高
        AudioManager audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        int max=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //设置带耳机时候的状态，照样扬声器播放
        audioManager.setMicrophoneMute(false);
        audioManager.setSpeakerphoneOn(true);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,max,0);
        //播放
        mediaPlayer.start();
    }
    
}