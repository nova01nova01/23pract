package com.example.a23pract;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // подключаем XML с кнопками
    }

    // Этот метод вызывается при нажатии любой из кнопок
    public void click(View v) {
        Intent i = new Intent(this, MediaService.class);   // готовим "заказ" сервису

        if (v.getId() == R.id.start) {
            startService(i);   // запустить сервис
        } else {
            stopService(i);    // остановить сервис
        }
    }
}