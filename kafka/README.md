# Kafka

## Kafka on Kubernetes

Prerequisites:
- Helm
- kubectl
- Strimzi Kafka Operator
```
$ helm repo add strimzi https://strimzi.io/charts/
$ helm repo update
$ helm upgrade --install strimzi-kafka-operator -n kafka strimzi/strimzi-kafka-operator

```

## Kafka

Single & ephemeral:
```
$ kubectl apply -n kafka -f https://raw.githubusercontent.com/strimzi/strimzi-kafka-operator/main/examples/kafka/kafka-ephemeral-single.yaml
$ kubectl get svc | my-kafka

```

Single & persistent:
```
$ kubectl apply -n kafka -f https://raw.githubusercontent.com/strimzi/strimzi-kafka-operator/main/examples/kafka/kafka-persistent-single.yaml

```