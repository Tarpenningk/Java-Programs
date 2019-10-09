@echo off
cls

set DRIVE_LETTER="%~dp0.."
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.6\bin;

ant run -Ddrive-letter=%DRIVE_LETTER%

