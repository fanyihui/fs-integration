@echo off
setlocal enabledelayedexpansion
set JAVA=%JAVA_HOME%\bin\java
set OPTS=-Xms512M -Xmx512M
set LIBPATH=..\lib
set CONFIG=..\conf
set CP=%CONFIG%;
set MAIN=com.fs.ie.mdgw.Main

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

java %OPTS% -cp %CP% %MAIN%