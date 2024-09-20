## JNI Performance test

### JNI can get slow when too many calls are made

### Run
#### Compile with `-h` to create c++ header file
```shell
javac -h target/ -d target/ src/com/can/*.java
```

#### Compile c++ binaries with JNI header files
- Windows dll
```bat
g++ -I "%JAVA_HOME%\include" -I "%JAVA_HOME%\include\win32" -shared -o target/performancetest.dll lib/performancetest.cpp
```
- Linux so **Compiled binary has to start with `lib` on linux**
```shell
g++ -I "$JAVA_HOME/include" -I "$JAVA_HOME/include/linux" -shared -o target/libperformancetest.so lib/performancetest.cpp
```

#### Run main
```shell
java -cp target/ -Djava.library.path=target/ com.can.Main
```
