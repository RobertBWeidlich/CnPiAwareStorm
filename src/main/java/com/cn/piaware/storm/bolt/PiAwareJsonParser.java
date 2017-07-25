package com.cn.piaware.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * break JSON document data from PiAware into single  hash table,
 * that is, if the input is:
 *
 *   { "now" : 1500941760.7,
 *    messages" : 261265633,
 *   aircraft" : [
 *    {"hex":"a70bd1","squawk":"4245","altitude":38700,"mlat":[],"tisb":[],"messages":29,"seen":0.4,"rssi":-15.9},
 *    {"hex":"4006c1","altitude":39000,"vert_rate":-64,"track":41,"speed":535,"mlat":[],"tisb":[],"messages":12,"seen":22.6,"rssi":-14.9},
 *    {"hex":"a83876","altitude":35000,"vert_rate":512,"track":3,"speed":449,"mlat":[],"tisb":[],"messages":26,"seen":17.3,"rssi":-15.5}
 *   ]
 * }
 *
 * then emit the three lines, for each aircraft, separately, as
 *    {"now" : 1500941760.7, "hex":"a70bd1","squawk":"4245","altitude":38700,"mlat":[],"tisb":[],"messages":29,"seen":0.4,"rssi":-15.9}
 *    {"now" : 1500941760.7, "hex":"4006c1","altitude":39000,"vert_rate":-64,"track":41,"speed":535,"mlat":[],"tisb":[],"messages":12,"seen":22.6,"rssi":-14.9}
 *    {"now" : 1500941760.7, "hex":"a83876","altitude":35000,"vert_rate":512,"track":3,"speed":449,"mlat":[],"tisb":[],"messages":26,"seen":17.3,"rssi":-15.5}
 */
public class PiAwareJsonParser extends BaseBasicBolt {
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // vvv -- Mon Jul 24 18:36:03 PDT 2017 -- vvv
        declarer.declare(new Fields(""));

    }



}
