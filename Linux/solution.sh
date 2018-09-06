#!/bin/bash
PARAMETERS=$1;

cat $PARAMETERS | sed -r "s/(.*)=(.*)/\1/g" > /tmp/vars_names;
cat $PARAMETERS | sed -r "s/(.*)=(.*)/echo $\1/g" > /tmp/vars;
cp text.txt /tmp/text.txt;

cat $PARAMETERS /tmp/vars | bash > /tmp/vars_values;

index=1;
for var in `cat /tmp/vars_names`;
do
    sed -i -r "s/@$var@/`head -$index /tmp/vars_values | tail -1`/g" /tmp/text.txt;
    index=$(($index+1));
done

cat /tmp/text.txt;
#cat /tmp/vars_names;
