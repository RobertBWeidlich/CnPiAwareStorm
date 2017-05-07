package com.cn.piaware.storm.util;

import java.net.URL;
import java.net.HttpURLConnection;

public class PiAwareHttpData {
    private static final String url_addr = "http://192.168.1.7:8080/data/aircraft.json";

    //public static void main() throws Exception {
    public void doit() throws Exception {
        System.out.println("in doit()");
        URL url = new URL(url_addr);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello!");
        PiAwareHttpData pa = new PiAwareHttpData();
        pa.doit();
    }
}
