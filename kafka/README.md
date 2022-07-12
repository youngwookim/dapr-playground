# Kafka

## Kafka on Kubernetes

Prerequisites:
- Helm
- kubectl
- Strimzi Kafka Operator
```
$ helm repo add strimzi https://strimzi.io/charts/
$ helm repo update
$ helm upgrade --install strimzi-kafka-operator -n kafka strimzi/strimzi-kafka-operator --create-namespace

```

## Kafka

Single & ephemeral:
```
$ kubectl apply -n kafka -f https://raw.githubusercontent.com/strimzi/strimzi-kafka-operator/main/examples/kafka/kafka-ephemeral-single.yaml
$ kubectl get kafka -A
$ kubectl get svc -n kafka | grep my-cluster
my-cluster-zookeeper-client   ClusterIP   10.43.14.163   <none>        2181/TCP                              2m15s
my-cluster-zookeeper-nodes    ClusterIP   None           <none>        2181/TCP,2888/TCP,3888/TCP            2m15s
my-cluster-kafka-brokers      ClusterIP   None           <none>        9090/TCP,9091/TCP,9092/TCP,9093/TCP   81s
my-cluster-kafka-bootstrap    ClusterIP   10.43.91.99    <none>        9091/TCP,9092/TCP,9093/TCP            81s

```

Single & persistent:
```
$ kubectl apply -n kafka -f https://raw.githubusercontent.com/strimzi/strimzi-kafka-operator/main/examples/kafka/kafka-persistent-single.yaml

```

## Dapr with Kafka

1. PubSub
- https://docs.dapr.io/reference/components-reference/supported-pubsub/setup-apache-kafka/

2. Binding
- https://docs.dapr.io/reference/components-reference/supported-bindings/kafka/