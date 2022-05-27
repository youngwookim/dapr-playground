# dapr-playground

## Dapr CLI

```
# https://docs.dapr.io/getting-started/install-dapr-cli/
# Mac (arm64)
$ arch -arm64 brew install dapr/tap/dapr-cli
$ dapr

(snip)

```

## Dapr init for Kubernetes

```
# Via CLI
$ dapr init --kubernetes --wait

# Via Helm
helm repo add dapr https://dapr.github.io/helm-charts/
helm repo update
# See which chart versions are available
helm search repo dapr --devel --versions

$ helm upgrade --install dapr dapr/dapr \
--namespace dapr-system \
--create-namespace \
--set global.ha.enabled=true \
--set global.logAsJson=true

```

KEDA for Auto scaling:
```
helm repo add kedacore https://kedacore.github.io/charts
helm repo update
helm install keda kedacore/keda --namespace keda --create-namespace
```

## Dapr Dashboard

TBD

## Samples

```
$ git clone https://github.com/dapr/quickstarts.git
$ cd quickstarts

# https://github.com/dapr/quickstarts/tree/master/tutorials/hello-kubernetes
$ cd tutorials/hellp-kuberntes
```

```
# state store (redis)
$ kubectl apply -f ./deploy/redis.yaml

## nodejs app with dapr sidecar
$ kubectl apply -f ./deploy/node.yaml
$ kubectl apply -f ./deploy/python.yaml

```

## Building blocks

### Service Invocation

### Publish & subscribe

## Dapr in production on Kubernetes

https://docs.dapr.io/operations/hosting/kubernetes/kubernetes-production/

1. HA
- TBD

2. Auto scaling
- TBD

3. CI/CD
- TBD

## Observability

https://docs.dapr.io/operations/monitoring/

- Traces

![](https://docs.dapr.io/images/open-telemetry-collector.png)

## FAQs

- Pub-Sub vs. Binding ??
  - https://github.com/dapr/quickstarts/issues/404
  ```
  In general, pub-sub is for dapr-to-dapr communication. Bindings are for integration with external services.
  ```

## Refs.

- https://dapr.io/
- https://blog.devgenius.io/sneak-peek-into-the-dapr-distributed-application-runtime-world-9dca2b76584b
- https://blog.devgenius.io/sneak-peek-into-the-dapr-distributed-application-runtime-world-9dca2b76584b#_Running_Example
- https://github.com/quarkiverse/quarkus-dapr