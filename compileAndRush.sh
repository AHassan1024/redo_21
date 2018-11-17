javac src/StateMachine.java -d out/
javac test/StateMachineTestRunner.java -sourcepath test/ -d testOut/ -cp "out/:lib/junit-4.12.jar"
java -cp "testOut/:out/:lib/junit-4.12.jar:lib/hamcrest-all-1.3.jar" StateMachineTestRunner
