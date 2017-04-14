package luohao.com.sportmeetv3.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by luohao3 on 2017/3/26.
 */

public class LinkService {
//    private static URL url;
    public static final String ADDRESS_API = "http://10.18.127.21:8888/SportMeetService/";//"";http://10.18.127.21:8888/SportMeetService/http://192.168.10.147:8888/SportMeetService/

    private static final String[] res = new String[1];
    public static String link(final String Data,  final String method, final String API) throws InterruptedException {
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null; //"http://localhost:8080/SportMeetService"
                try {
                    url = new URL(API);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod(method);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(Data);
                    objectOutputStream.flush();
                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf8"));
                        String s = "";
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            s = s + line;
                        }
                        res[0] = s;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join();
        return res[0];
    }
}
