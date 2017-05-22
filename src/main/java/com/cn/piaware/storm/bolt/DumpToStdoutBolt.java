package com.cn.piaware.storm.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

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
