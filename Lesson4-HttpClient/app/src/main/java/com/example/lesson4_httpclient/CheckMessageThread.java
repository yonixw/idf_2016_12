package com.example.lesson4_httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by eladlavi on 14/12/2016.
 */

public class CheckMessageThread extends Thread {

    private boolean go = true;
    private String existingMessage;
    private GotNewMessageListener listener;

    public CheckMessageThread(GotNewMessageListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while(go){
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try{
                URL url = new URL(MainActivity.BASE_URL + "?action=check");
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
                result = URLDecoder.decode(result, "utf-8");
                if(!result.equals(existingMessage)){
                    this.existingMessage = result;
                    if(listener != null)
                        listener.onNewMessage(result);
                }
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
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public interface GotNewMessageListener{
        void onNewMessage(String message);
    }

    public void stopChecking(){
        go = false;
        interrupt();
    }
}
