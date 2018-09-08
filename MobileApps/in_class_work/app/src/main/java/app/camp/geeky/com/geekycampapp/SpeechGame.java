package app.camp.geeky.com.geekycampapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SpeechGame extends AppCompatActivity implements View.OnClickListener {

    TextToSpeech toSpeech;
    boolean isInitialised;

    TextView tvSpeech;
    TextView yesOrNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_game);

        tvSpeech = findViewById(R.id.tvSpeech);
        yesOrNo = findViewById(R.id.yesOrNoProperty);

        findViewById(R.id.bSpeak).setOnClickListener(this);
        findViewById(R.id.bDictate).setOnClickListener(this);
        findViewById(R.id.bFindOut).setOnClickListener(this);

        initSpeech();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSpeak:
                speakPressed();
                break;
            case R.id.bDictate:
                dictatePressed();
                break;
            case R.id.bFindOut:
                speakPressed();
                break;
        }
    }

    public void initSpeech() {
        isInitialised = false;
        toSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    isInitialised = true;
                }
            }
        });
    }

    public void speakPressed() {
        Toast.makeText(this, "Speak Pressed", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);

        startActivityForResult(i, 200);
    }

    public void dictatePressed() {
        Toast.makeText(this, "Dictate Pressed", Toast.LENGTH_SHORT).show();

        if (isInitialised) {
            toSpeech.speak("Hello Geeky Camp!", TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            Toast.makeText(this, "Object not initialized properly!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Map<String, String> questionsAndAnswers;
        if (requestCode == 200) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String sResult = result.get(0);
                tvSpeech.setText(sResult);

                questionsAndAnswers = new HashMap<String, String>();
                questionsAndAnswers.put("how old are you","15");
                questionsAndAnswers.put("which brand is your laptop from","asus");

                if (questionsAndAnswers.containsKey(sResult.toLowerCase())) {
                    yesOrNo.setText(questionsAndAnswers.get(sResult.toLowerCase()));
                } else {
                    yesOrNo.setText("I can't answer you.");
                }
            }

        }
    }
}
