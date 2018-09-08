package app.camp.geeky.com.geekycampapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Activity activity;

    Button bSpeechGame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        activity = this;

        bSpeechGame = findViewById(R.id.bSpeechGame);
        bSpeechGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tag!","Button CLicked!");

                Intent i = new Intent(activity,SpeechGame.class);

                startActivity(i);
            }
        });
    }
}
