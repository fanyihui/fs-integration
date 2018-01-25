export MDGW_HOME="/opt/fsie_mdgw/"
export JAVA=$JAVA_HOME/bin/java
export JAVA_OPTS=-Xms512M -Xmx512M -Xss128k -XX:+AggressiveOpts -XX:+UseParallelGC -XX:NewSize=64M
export LIBPATH=../lib
export CONFIG = ../conf
export CP=$CONFIG:
for jarz in $LIBPATH/*.jar
do CP=$CP:$jarz
done
export CP

echo ===============================================================================
echo.
echo Engine Startup Environment
echo.
echo JAVA: $JAVA
echo.
echo CONFIG: $CONFIG
echo.
echo JAVA_OPTS: $JAVA_OPTS
echo.
echo CLASSPATH: $CP
echo.
echo ===============================================================================
echo.

$JAVA $JAVA_OPTS -cp “$CP” com.fs.ie.mdgw.Main