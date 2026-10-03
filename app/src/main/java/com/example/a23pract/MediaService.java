package com.example.a23pract;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaService extends Service {   // наследуемся от Service, чтобы это был сервис

    private MediaPlayer ambientMediaPlayer;   // сам плеер

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // создаём плеер из файла
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.music);
        ambientMediaPlayer.setLooping(true);   // зацикливаем, чтобы играло без остановки
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ambientMediaPlayer != null) {
            ambientMediaPlayer.start();   // запуск воспроизведения
        }
        return START_STICKY;   // если система убьёт сервис — перезапустит его
    }

    @Override
    public void onDestroy() {
        if (ambientMediaPlayer != null) {
            ambientMediaPlayer.stop();      // останавливаем звук
            ambientMediaPlayer.release();   // освобождаем память
            ambientMediaPlayer = null;
        }
        super.onDestroy();
    }
}