package com.cn.piaware.storm.topology;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;

public class PiAwareTopology {
    public static void main(String[] args) {

        /*
         * 1. print properties in alphbetical order
         */
        Properties props = System.getProperties();
        Enumeration<Object> ek = props.keys();
        Collections.sort(ek);

        while (ek.hasMoreElements()) {
            String key = ek.nextElement().toString();
            String val = props.get(key).toString();
            System.out.println(key + "=" + val);
        }

        List<Object> ll = new ArrayList(ek);


        /*
         * 2. read properties file from correct place in Maven File Directory Structure
         */
        CompositeConfiguration config = new CompositeConfiguration();

        //config.addConfiguration(new PropertiesConfiguration("piaware.properties"));
        //config.addConfiguration(new PropertiesConfiguration(""));

        /*
        Iterator<String> keys = config.getKeys();

        String kk = keys.toString();

        while (keys.hasNext()) {
            String key = keys.next();
            String val = config.getProperty(key).toString();
            System.out.println(key + " = " + val);
        }
        */

    }
}
