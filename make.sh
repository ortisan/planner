#!/bin/sh

#https://stackoverflow.com/questions/2870992/automatic-exit-from-bash-shell-script-on-error
abort()
{
    echo >&2 '
***************
*** ABORTED ***
***************
'
    echo "An error occurred. Exiting..." >&2
    exit 1
}

trap 'abort' 0

set -e

YOUR_DOCKER_HUB_USER=tentativafc

# Building services
cd planner-backend
mvn clean compile package
cd -

trap : 0

echo >&2 '
************
*** DONE *** 
************
'