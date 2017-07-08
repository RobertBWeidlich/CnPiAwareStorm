package com.cn.piaware.storm.topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.utils.Utils;
import org.apache.storm.topology.base.BaseRichSpout;

import com.cn.piaware.storm.spout.OneToTenSpout;
import com.cn.piaware.storm.bolt.PassThruBolt;
import com.cn.piaware.storm.bolt.DumpToStdoutBolt;

/**
 * Simple Topology using OneToTenSpout, and
 * PassThruBolt and DumpToStdoutBolt
 */
public class SimpleStormTopology {
    public static void main(String[] args)  throws Exception {
        boolean localMode = true;  // todo: alter this with command line arg
        //boolean localMode = false;

        TopologyBuilder builder = new TopologyBuilder();

        BaseRichSpout ottSpout = new OneToTenSpout();
        //builder.setSpout("one-to-ten", new OneToTenSpout());
        builder.setSpout("one-to-ten", ottSpout);

        builder.setBolt("pass-thru", new PassThruBolt())
                .shuffleGrouping("one-to-ten");
        builder.setBolt("dump-to-stdout", new DumpToStdoutBolt())
                .shuffleGrouping("pass-thru");

        Config config = new Config();
        config.setDebug(true);

        StormTopology topology = builder.createTopology();

        if (localMode) {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("simple-topology", config, topology);
            //Utils.sleep(60000); // run for 1 minute
            Utils.sleep(180000); // run for 3 minutes
            //Utils.sleep(300000); // run for 5 minutes
            //Utils.sleep(600000); // run for 10 minutes
            cluster.killTopology("simple-topology");
            cluster.shutdown();
        }
        else {
            config.setNumWorkers(3);
            config.setMessageTimeoutSecs(60);
            StormSubmitter.submitTopology("simple-topology", config, topology);
        }
    }
}
