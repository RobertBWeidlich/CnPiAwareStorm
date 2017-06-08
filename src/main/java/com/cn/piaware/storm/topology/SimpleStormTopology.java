package com.cn.piaware.storm.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.utils.Utils;

import com.cn.piaware.storm.spout.OneToTenSpout;
import com.cn.piaware.storm.bolt.PassThruBolt;
import com.cn.piaware.storm.bolt.DumpToStdoutBolt;

/**
 * Simple Topology using OneToTenSpout, and
 * PassThruBolt and DumpToStdoutBolt
 */
public class SimpleStormTopology {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("one-to-ten", new OneToTenSpout());

        builder.setBolt("pass-thru", new PassThruBolt())
                .shuffleGrouping("one-to-ten");
        builder.setBolt("dump-to-stdout", new DumpToStdoutBolt())
                .shuffleGrouping("pass-thru");

        Config config = new Config();
        config.setDebug(true);

        StormTopology topology = builder.createTopology();

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("simple-topology", config, topology);

        Utils.sleep(60000); // run for 1 minute
        //Utils.sleep(180000); // run for 3 minutes
        //Utils.sleep(300000); // run for 5 minutes
        //Utils.sleep(600000); // run for 10 minutes
        cluster.killTopology("simple-topology");
        cluster.shutdown();
    }
}
