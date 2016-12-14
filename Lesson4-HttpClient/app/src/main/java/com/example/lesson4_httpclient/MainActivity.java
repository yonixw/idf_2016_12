package com.example.lesson4_httpclient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends Activity implements CheckMessageThread.GotNewMessageListener {

    TextView lblMessage;
    EditText txtMessage;
    Handler handler = new Handler();
    Button btnSend;
    CheckMessageThread checkMessageThread;

    public static final String BASE_URL = "http://146.148.28.47/SimpleChat/MainServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMessage = (TextView)findViewById(R.id.lblMessage);
        txtMessage = (EditText)findViewById(R.id.txtMessage);
        btnSend = (Button)findViewById(R.id.btnSend);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(checkMessageThread == null) {
            checkMessageThread = new CheckMessageThread(this);
            checkMessageThread.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(checkMessageThread != null){
            checkMessageThread.stopChecking();
            checkMessageThread = null;
        }
    }

    public void btnSend(View view) {
        String message = txtMessage.getText().toString();
        if(message.isEmpty()){
            Toast.makeText(this, "please type something", Toast.LENGTH_SHORT).show();
            return;
        }

        btnSend.setText("please wait...");
        btnSend.setEnabled(false);
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lblMessage.setText("hi");
                        btnSend.setEnabled(true);
                        btnSend.setText("Send");
                    }
                });
            }
        });
        thread.start();*/

        new AsyncTask<String, Void, Boolean>(){

            @Override
            protected Boolean doInBackground(String... params) {
                String message = params[0];
                HttpURLConnection urlConnection = null;
                InputStream inputStream = null;
                try{
                    message = URLEncoder.encode(message, "utf-8");
                    URL url = new URL(BASE_URL + "?action=send&message="+message);
                    urlConnection = (HttpURLConnection)url.openConnection();
                    urlConnection.setUseCaches(false);
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();
                    inputStream = urlConnection.getInputStream();
                    byte[] buffer = new byte[1024];
                    int actuallyRead;
                    StringBuilder stringBuilder = new StringBuilder();
                    while((actuallyRead = inputStream.read(buffer)) != -1){
                        stringBuilder.append(new String(buffer, 0, actuallyRead));
                    }
                    inputStream.close();
                    inputStream = null;
                    String result = stringBuilder.toString();
                    if(result.equals("ok"))
                        return true;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream != null)
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    if(urlConnection != null)
                        urlConnection.disconnect();
                }

                return false;
            }

            @Override
            protected void onPostExecute(Boolean success) {
                btnSend.setEnabled(true);
                btnSend.setText("Send");
                if(success)
                    txtMessage.setText("");
            }
        }.execute(message);



    }

    @Override
    public void onNewMessage(String message) {
        handler.post(new MessageRunnable(message) {
            @Override
            public void run() {
                lblMessage.setText(this.message);
            }
        });
    }
}
abstract class MessageRunnable implements Runnable{

    String message;

    public MessageRunnable(String message) {
        this.message = message;
    }

}