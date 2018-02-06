#!/bin/bash

MDGW_HOME="/opt/mdgw"
export JAVA_OPTS="-Xms512M -Xmx512M"
LIBPATH=${MDGW_HOME}/lib
CONFIG = ${MDGW_HOME}/conf
CP=${CONFIG}:
for jarz in $LIBPATH/*.jar
do CP=$CP:$jarz
done

echo ===============================================================================
echo
echo Engine Startup Environment
echo
echo
echo CONFIG: $CONFIG
echo
echo JAVA_OPTS: $JAVA_OPTS
echo
echo CLASSPATH: $CP
echo
echo ===============================================================================
echo

java $JAVA_OPTS -cp $CP com.fs.ie.mdgw.Main