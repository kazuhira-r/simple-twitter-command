#!/bin/bash

SCRIPT_DIR=`dirname $0`

cd ${SCRIPT_DIR}/src
groovy search.groovy "$@"
