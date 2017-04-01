@echo off

set classpath=%classpath%;lib/gnujaxp.jar;lib/jcommon-1.0.0.jar;lib/jfreechart-1.0.0.jar;lib/junit.jar;lib/servlet.jar;

javac entidades\*.java
javac procesos\*.java
javac Ventanas\*.java

pause


