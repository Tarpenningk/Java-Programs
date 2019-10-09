@echo off
cls

set DRIVE_LETTER=%1:

set PLAYER=%2

set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.6\bin;c:\Windows

ant run -Ddrive-letter=%DRIVE_LETTER% -Dplayer=%PLAYER%

::ant run -Ddrive-letter=%DRIVE_LETTER%


