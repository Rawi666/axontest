kubectl apply -f ./clusterrole.yaml
kubectl apply -f ./postgresaxon-deployment.yaml
kubectl apply -f ./postgresaxon-service.yaml
kubectl apply -f ./axonconsumer-deployment.yaml
kubectl apply -f ./axonproducer-deployment.yaml
