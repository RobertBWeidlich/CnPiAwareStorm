package com.cn.piaware.storm.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * simply pass through data -- a tuple with a single value
 */
public class PassThruBolt extends BaseBasicBolt {
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("pt-data-out"));
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector outputCollector) {
        String inData = tuple.getStringByField("ott-data-out");
        outputCollector.emit(new Values(inData));
    }
}
