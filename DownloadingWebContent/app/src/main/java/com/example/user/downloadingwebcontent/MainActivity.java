package com.example.user.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String , Void , String>{

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;

            try{
                url = new URL(urls[0]);

                httpURLConnection =(HttpURLConnection) url.openConnection();

                InputStream in = httpURLConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while(data != -1)
                {
                    char current = (char)data;
                    result = result + current;
                    data = reader.read();
                }

                return result;
            }
            catch(Exception e){
                e.printStackTrace();
                return "Failed";
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask tast = new DownloadTask();

        String result = null;
        try {
            result = tast.execute("https://www.ecowebhosting.co.uk/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.i("Contents of Url - >" , result);
    }
}
