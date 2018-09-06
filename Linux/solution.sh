#!/bin/bash
PARAMETERS=$1;

cat $PARAMETERS | sed -r "s/(.*)=(.*)/\1/g" > ./bin/parameter_name;
cat $PARAMETERS | sed -r "s/(.*)=(.*)/echo $\1/g" > ./bin/parameters;
cp text.txt ./bin/replaced.txt;

cat $PARAMETERS ./bin/parameters | bash > ./bin/parameter_value;

index=1;
#===============================THIS IS WORKING в)=======================================
for var in `cat ./bin/parameter_name`;
do
    sed -i -r "s/@$var@/`head -$index ./bin/parameter_value | tail -1`/g" ./bin/replaced.txt;
    index=$(($index+1));
done
#========================================================================================


cat ./bin/replaced.txt;
#cat /tmp/vars_names;
