#CnPiAwareStorm

An Apache Storm topology to process real-time aircraft
data received from a
[PiWare](http://flightaware.com/adsb/piaware)
device.

### Simple Topology
This is a minimalist topology that can be used as a starting point to build a more complex
topology.

```
 +----------+----------+ 
 |                     |
 |    OneToTenSpout    | id = "one-to-ten"
 |                     |
 +----------+----------+ 
            |
            | "ott-data-out"
            |
            v
 +----------+----------+ 
 |                     |
 |    PassThruBolt     | id = "pass-thru"
 |                     |
 +----------+----------+ 
            |
            | "pt-data-out"
            |
            v
 +----------+----------+ 
 |                     |
 |  DumpToStdoutBolt   | id = "dump-to-stdout"
 |                     |
 +----------+----------+ 
 
```




