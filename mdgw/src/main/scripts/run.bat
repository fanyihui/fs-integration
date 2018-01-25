@echo off
setlocal enabledelayedexpansion //设置延迟环境变量扩充
set JAVA=%JAVA_HOME%\bin\java //java命令
set OPTS=-Xms512M -Xmx512M -Xss128k -XX:+AggressiveOpts -XX:+UseParallelGC -XX:NewSize=64M //jvm参数
set LIBPATH=..\lib
set CONFIG=..\conf
set CP=%CONFIG%;
set MAIN=com.fs.ie.mdgw.Main

//循环加载jar包
for /f %%i in ('dir /b %LIBPATH%\*.jar^|sort') do (
set CP=!CP!%LIBPATH%\%%i;
)

echo ===============================================================================
echo.
echo Engine Startup Environment
echo.
echo JAVA: %JAVA%
echo.
echo CONFIG: %CONFIG%
echo.
echo JAVA_OPTS: %OPTS%
echo.
echo CLASSPATH: %CP%
echo.
echo ===============================================================================
echo.

%JAVA% %OPTS% -cp %CP% %MAIN% //运行