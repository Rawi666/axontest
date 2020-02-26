docker rm -f $(docker ps -q -a)
docker rmi $(docker images --filter "dangling=true" -q --no-trunc)
