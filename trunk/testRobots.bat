set robotA=eve
set robotB=walle
set robotA2=eve_offspring
set robotB2=walle_offspring
set team=bcrobots
set battle=test.battle
set resultFile=resultadoCombate.txt
set robocodeHome=.\robocode
REM -CONFIGEND-

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\%team%\%robotA%.java"

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\%team%\%robotB%.java"

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\%team%\%robotA2%.java"

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\%team%\%robotB2%.java"

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\sample\Robben.java"

.\jikes-1.22\bin\jikes.exe -deprecation -g -Xstdout +T4 -classpath ".\rt.jar";%robocodeHome%\robocode.jar;robots ".\robots\sample\Guti.java"


SET COPYCMD=/Y
mkdir %robocodeHome%\robots\%team%\
xcopy .\robots\%team%\*.class %robocodeHome%\robots\%team%\
mkdir %robocodeHome%\robots\sample\
xcopy .\robots\sample\*.class %robocodeHome%\robots\sample\

cd %robocodeHome%\
java -Xmx512M -Dsun.io.useCanonCaches=false -jar robocode.jar -battle .\..\%battle% -results .\..\%resultFile%
cd..
exit
