## Performance test

### Run
#### Compile with `-h` to create c++ header file
```shell
javac -h target/ -d target/ src/com/can/*.java
```

#### Compile c++ binaries with JNI header files
- Windows dll
```bat
g++ -I "%JAVA_HOME%\include" -I "%JAVA_HOME%\include\win32" -shared -o target/calculator.dll lib/calculator.cpp
```
- Linux so **Compiled binary has to start with `lib` on linux**
```shell
g++ -I "$JAVA_HOME/include" -I "$JAVA_HOME/include/linux" -shared -o target/libcalculator.so lib/calculator.cpp
```

#### Run main
```shell
java -cp target/ -Djava.library.path=target/ com.can.Main
```
