package com.cn.piaware.storm.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuples.Fields;
import org.apache.storm.tuples.Values;
import org.apache.storm.tuples.Utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PiAwareDataSpout extends RichSpout {
    private SpoutOutputCollector outputCollector = null;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("piaware-json-data"));
    }

    @Override
    public void open(Map map, TopologyContext context,
                     SpoutOutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    @Override
    nextTuple() {
        String outStr = "1st line\n2nd line\n3rd line";
        outputCollector.emit(new Values(outStr));
        Utils.sleep(1000); // 1 second
    }
}
