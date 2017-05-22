package com.cn.piaware.storm.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Generate "1", "2", "3", ... "10"
 */
public class OneToTenSpout  extends BaseRichSpout {
    private SpoutOutputCollector outputCollector = null;
    private long loopi = 0;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("ott-data-out"));
    }

    @Override
    public void open(Map map, TopologyContext context, SpoutOutputCollector outputCollector) {
        this.loopi = 0;
        this.outputCollector = outputCollector;
    }

    @Override
    /**
     * pause 10 seconds between iterations, 1 second between each output
     */
    public void nextTuple() {
        ++loopi;
        long count = 0;
        for (int i = 0; i < 10; i++) {
            String val = Long.toString(loopi) + "-" + Integer.toString(i+1);
            //outputCollector.emit(new Values(Integer.toString(i)));
            outputCollector.emit(new Values(val));
            Utils.sleep(1000);
        }
        Utils.sleep(10000);
    }
}
