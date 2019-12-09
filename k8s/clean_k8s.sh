kubectl delete deployment axonproducer
kubectl delete deployment axonconsumer
kubectl delete ClusterRoleBinding jgroups-kubeping-api-access
kubectl delete ClusterRole jgroups-kubeping-pod-reader
kubectl delete ServiceAccount jgroups-kubeping-service-account
kubectl delete deployment postgresaxon
kubectl delete service postgresaxon
