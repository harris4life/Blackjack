package edu.towson.cdough11.finalproject_blackjack;

import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static edu.towson.cdough11.finalproject_blackjack.R.id.rulesText;

/**
 * Created by tsuba on 12/2/2017.
 */

public class RulesDownloader {

    //Using our own host to access the rules
    static String API = "https://edufit.000webhostapp.com/blackjackrules.txt";

    public static String downloadRules(){
        try {
            URL url = new URL(API);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            char[] bytes = new char[1024];
            StringBuilder builder = new StringBuilder();
            int byteCount = reader.read(bytes);
            while (byteCount > 0) {
                builder.append(bytes, 0, byteCount);
                byteCount = reader.read(bytes);
            }
            return builder.toString();
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}