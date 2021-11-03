javac -d bin -sourcepath src src\com\ticTacToe\TicTacToe.java
jar -cmf manifest.mf sample.jar  -C bin .
java -jar .\sample.jar
