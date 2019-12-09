kubectl apply -f ./clusterrole.yaml
kubectl apply -f ./postgresaxon-deployment.yaml
kubectl apply -f ./postgresaxon-service.yaml
echo Waiting 10s before deploying axon
sleep 10
kubectl apply -f ./axonconsumer-deployment.yaml
kubectl apply -f ./axonproducer-deployment.yaml
