package com.cn.piaware.storm.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

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

    /**
     * pause 10 seconds between iterations, 1 second between each output
     */
    @Override
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
