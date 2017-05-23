package com.cn.piaware.storm.topology;

import java.util.Iterator;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;

public class PiAwareTopology {
    public static void main(String[] args) {
        CompositeConfiguration config = new CompositeConfiguration();

        //config.addConfiguration(new PropertiesConfiguration("piaware.properties"));
        config.addConfiguration(new PropertiesConfiguration(""));

        Iterator<String> keys = config.getKeys();

        String kk = keys.toString();

        while (keys.hasNext()) {
            String key = keys.next();
            String val = config.getProperty(key).toString();
            System.out.println(key + " = " + val);
        }

    }
}
