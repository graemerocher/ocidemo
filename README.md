## Micronaut Oracle Cloud Sample Application

This is a sample application used in a number of videos published on YouTube:

https://www.youtube.com/watch?v=vyMVyQumUj8&list=PLiKP0AiDx1K3p_0zqureLNwkbdcpaZiz5

### Running Locally

Try run the application locally start a local Oracle and Kafka-compliant server (Kafka or Red Panda). For example with Docker:

```bash
# Start Oracle
docker run -p 1521:1521 gvenzl/oracle-xe:slim -e ORACLE_PASSWORD=oracle

# Start Red Panda
docker run --pull=always --name=redpanda-1 --rm \
-p 9092:9092 \
docker.vectorized.io/vectorized/redpanda:latest \
start \
--overprovisioned \
--smp 1  \
--memory 1G \
--reserve-memory 0M \
--node-id 0 \
--check=false
```

You can then start the application with `./gradlew run` or run the tests with `./gradlew test`.

### Running on Oracle Cloud

To run on Oracle cloud you need a compute instance or OKE setup with [instance principals](https://blogs.oracle.com/developers/post/accessing-the-oracle-cloud-infrastructure-api-using-instance-principals) configured that grant access to the requires resources (Autonomous Database, Streaming, Application Performance Monitoring etc.)

In addition the following environment variables should be set on the target you deploy to:

* `ATP_OCID` - The OCID of the autonomous database instance
* `ATP_USER` - The schema user name
* `ATP_PASS` - The schema user password
* `OCI_REGION` (optional defaults to ashburn) - The OCI region
* `OCI_STREAM_USER` - The OCI streaming user for Kafka messages
* `OCI_STREAM_PASS` - The OCI streaming password for Kafka messages
* `OCI_APM_AGENT_ID` - The Application Performance Monitoring (APM) agent ID for tracing
* `OCI_APM_KEY` - The key for sending tracing information to APM
* `OCI_MONITORING_NAMESPACE` - The namespace to use for OCI Monitoring
* `OCI_MONITORING_RESOURCE_GROUP` - The resource group to use for OCI Monitoring

