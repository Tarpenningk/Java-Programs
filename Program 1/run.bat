@echo off
cls

set DRIVE_LETTER=%1:
set PATH=%DRIVE_LETTER%\Java\bin;c:\Windows;c:\Windows\system32
set CLASSPATH=./build

java -cp %CLASSPATH% cds.CDSort >out.txt
