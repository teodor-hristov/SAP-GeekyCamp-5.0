#!/bin/bash
PARAMETERS=$1;

cat $PARAMETERS | sed -r "s/(.*)=(.*)/\1/g" > /tmp/vars_names;
cat $PARAMETERS | sed -r "s/(.*)=(.*)/echo $\1/g" > /tmp/vars;
