package edu.towson.cdough11.finalproject_blackjack;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RulesActivity extends AppCompatActivity {

    TextView gameRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        gameRules = (TextView)findViewById(R.id.rulesText);

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            String rules;
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                gameRules.setText(rules);
            }

            @Override
            protected Void doInBackground(Void... params) {
                rules = RulesDownloader.downloadRules();
                return null;
            }
        };
        task.execute();
    }
}