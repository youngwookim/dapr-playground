# Redis


## Redis on Kubernetes

Redis Operator:
- https://github.com/OT-CONTAINER-KIT/redis-operator
- https://github.com/spotahome/redis-operator

Redis standalone:
```
$ helm repo add ot-helm https://ot-container-kit.github.io/helm-charts/
$ helm repo update
$ helm upgrade --install redis ot-helm/redis --install --namespace default

$ kubectl get svc | grep redis

```

Via Helm:
```
$ helm repo add bitnami https://charts.bitnami.com/bitnami
$ helm install redis bitnami/redis

```

## Redis statestore & Pub/Sub for Dapr

```
apiVersion: dapr.io/v1alpha1
kind: Component
metadata:
  name: statestore
spec:
  type: state.redis
  version: v1
  metadata:
  - name: "redisHost"
    value: "REPLACE_HOST"
  - name: "redisPassword"
    value: "REPLACE_SECRET"
---
apiVersion: dapr.io/v1alpha1
kind: Component
metadata:
  name: messagebus
spec:
  type: pubsub.redis
  version: v1
  metadata:
  - name: "redisHost"
    value: "REPLACE_HOST"
  - name: "redisPassword"
    value: "REPLACE_SECRET"
```
