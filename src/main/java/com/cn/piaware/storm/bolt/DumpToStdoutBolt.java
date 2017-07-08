package com.cn.piaware.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * Print input to stdout
 */
public class DumpToStdoutBolt extends BaseBasicBolt {
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // no output
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector outputCollector) {
        String inData = tuple.getStringByField("pt-data-out");
        System.out.println(">>>" + inData + "<<<");
    }
}
