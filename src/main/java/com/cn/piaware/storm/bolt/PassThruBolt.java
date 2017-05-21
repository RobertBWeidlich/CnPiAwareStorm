package com.cn.piaware.storm.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class PassThruBolt extends BaseBasicBolt {
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        /* 20170521.1450 */
        declarer.declare(new Fields("pt-data-out"));
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector outputCollector) {

    }
}
