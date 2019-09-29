## quarkus-xps

Quarkus Experiments


<br/>

## Run in Dev Mode (hot deployment)

Launching it using `mvn compile quarkus:dev`. Result (initial output):
```bash
 INFO  [io.qua.dep.QuarkusAugmentor] (main) Beginning quarkus augmentation
 INFO  [io.qua.dep.QuarkusAugmentor] (main) Quarkus augmentation completed in 974ms
 INFO  [io.quarkus] (main) Quarkus 0.22.0 started in 1.454s. Listening on: http://[::]:8080
 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy]
```

<br/>

## Usage

`HelloResource` exposes some simple endpoints that can be called using:
- `curl localhost:8080/hello`
- `curl localhost:8080/hello/someString`
- `curl localhost:8080/hello/async`
- `curl localhost:8080/hello/async/someString`

<br/>

## Memory Consumption

todo: package and options

Use `ps -o pid,rss,command -p $(pgrep quarkus-xps)` to see how much memory (native, not just heap) is being used.

<br/>

## Creation

This project was created using:
```bash
$ mvn io.quarkus:quarkus-maven-plugin:0.22.0:create \
      -DprojectGroupId=org.devisions -DprojectArtifactId=quarkus-xps
```
