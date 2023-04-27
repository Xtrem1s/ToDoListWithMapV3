package com.example.practice2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private MapView mapview;
    ListView userList;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActionBar ab = getActionBar();
//        ab.setBackgroundDrawable(new ColorDrawable(0xffFF00FF));
        MapKitFactory.setApiKey("f21b5a94-7944-4eec-a01d-a8cf9be04c16");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(0xff9CC249));


        // Укажите имя Activity вместо map.
        setContentView(R.layout.activity_main);

        mapview = (MapView)

                findViewById(R.id.mapview);
        mapview.getMap().

                move(
                        new CameraPosition(new Point(56.0184, 92.8672), 11.0f, 0.0f, 0.0f),
                        new

                                Animation(Animation.Type.SMOOTH, 0),
                        null);


    }


    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }

    public void showDialogAnecdote(View v) {
        Anecdote dialog = new Anecdote();
        dialog.show(getSupportFragmentManager(), "custom");
    }

    public void showDialogListTasks(View v) {
        Intent myIntent = new Intent(this, MainActivity2.class);
        startActivity(myIntent);
    }


}