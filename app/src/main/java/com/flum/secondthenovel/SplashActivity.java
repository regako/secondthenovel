package com.flum.secondthenovel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        buildAsset();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 100);
    }

    private void buildAsset(){
        String[] script = ReadFromfile("script.txt").split("&&");
        String[] question = ReadFromfile("questions.txt").split("&&");

        for(int i = 0 ; i<script.length ; i++) {
            Contents.getScript().add(script[i]);
        }

        for(int i = 0 ; i<question.length ; i++) {
            Contents.getQuestions().add(question[i]);
        }
    }

    private String ReadFromfile(String fileName) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        boolean result = false;
        try {
            fIn = getResources().getAssets()
                    .open(fileName);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line;
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
            result = true;
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        if(result) {
            return returnString.toString();
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            finish();
            return "";
        }
    }
}
