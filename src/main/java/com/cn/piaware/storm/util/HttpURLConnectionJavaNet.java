package com.cn.piaware.storm.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Evaluate java.net.HttpURLConnection
 * see https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 */
public class HttpURLConnectionJavaNet {
    private static final String  USER_AGENT =    "Mozilla/5.0";
    private static final String  PIAWARE_URL =   "http://192.168.1.7:8080/data/aircraft.json";
    private static final boolean KEEP_NEWLINES = true;

    private String userAgent = null;
    private String srvUrl =    null;

    public static void main(String[] args) {
        HttpURLConnectionJavaNet huc = new HttpURLConnectionJavaNet(USER_AGENT, PIAWARE_URL);

        try {
            //hucjn.sendGet();
            String data = huc.get();
            System.out.println(">>>" + data + "<<<");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpURLConnectionJavaNet () {
        this(USER_AGENT, PIAWARE_URL);
    }

    public HttpURLConnectionJavaNet (String urlStr) {
        this(USER_AGENT, urlStr);
    }

    public HttpURLConnectionJavaNet (String userAgent, String urlStr) {
        this.userAgent = userAgent;
        this.srvUrl =    urlStr;
    }

    private String get() throws Exception {
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(this.srvUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", this.userAgent);
            int responseCode = connection.getResponseCode();
            System.out.println("responseCode: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String inputLine;

            while((inputLine= in.readLine()) != null) {
                sb.append(inputLine);
                if (KEEP_NEWLINES)
                    sb.append("\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return sb.toString();
    }
}
