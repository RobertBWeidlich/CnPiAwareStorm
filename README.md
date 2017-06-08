#CnPiAwareStorm

An Apache Storm topology to process real-time aircraft
data received from a
[PiAware](http://flightaware.com/adsb/piaware)
device.

### Simple Topology
This is a minimalist topology that can be used as a starting point to build a more complex
topology.

```
 SimpleStormTopology.java
 
 +----------+----------+ 
 |                     |
 |    OneToTenSpout    | id = "one-to-ten"
 |                     |
 +----------+----------+ 
            |
            | ("ott-data-out")
            |
            v
 +----------+----------+ 
 |                     |
 |    PassThruBolt     | id = "pass-thru"
 |                     |
 +----------+----------+ 
            |
            | ("pt-data-out")
            |
            v
 +----------+----------+ 
 |                     |
 |  DumpToStdoutBolt   | id = "dump-to-stdout"
 |                     |
 +----------+----------+ 
 
```
To run the SimpleStormTopology topology from the Linux command line:
```
  $ cd .../CnPiAwareStorm/target
  $ java -cp ./CnPiAwareStorm-0.0.20170325.1755-jar-with-dependencies.jar com.cn.piaware.storm.topology.SimpleStormTopology
```

### PiAware Topology
```
 PiAwareTopology.java
 
 +----------+----------+ 
 |                     |
 |  PiAwareDataSpout   | id = "piaware-data"
 |                     |
 +----------+----------+ 
            |
            | ("piaware-json-data")
            |
            v
 +----------+----------+ 
 |                     |
 | PiAwareJsonParser   | id = "piaware-json-parser"
 |                     |
 +----------+----------+ 
            |
            | ("time", "flight-data")
            |
            v

```
