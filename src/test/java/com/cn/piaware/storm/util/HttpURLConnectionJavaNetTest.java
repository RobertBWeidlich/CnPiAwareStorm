package com.cn.piaware.storm.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HttpURLConnectionJavaNetTest {
    private static final String USER_AGENT =  "Mozilla/5.0";
    private static final String PIAWARE_URL = "http://192.168.1.7:8080/data/aircraft.json";

    HttpURLConnectionJavaNet huc = null;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //HttpURLConnectionJavaNet huc = new HttpURLConnectionJavaNet(USER_AGENT, PIAWARE_URL);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    public void testAbc() {

    }

}