#!/usr/bin/env bash

set -eo pipefail

TIME=`date "+%Y%m%d%H%M"`
GIT_REVISION=`git log -1 --pretty=format:"%h"`
REGISTRY_IP="172.20.4.27"
REGISTRY_NAME="springcloudfeign"

modules=( eureka-server eureka-provider eureka-consumer-feign )

for module in "${modules[@]}"; do
    docker build -t "${REGISTRY_IP}/${REGISTRY_NAME}/${module}:${TIME}_${GIT_REVISION}" ${module}
    docker push "${REGISTRY_IP}/${REGISTRY_NAME}/${module}:${TIME}_${GIT_REVISION}"


done