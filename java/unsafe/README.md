## Unsafe native array

### This is just a test to see unsafe capabilities and its probably unstable, due to gc changing addresses of java objects.

### Compile
```shell
javac -XDignore.symbol.file -h target/ -d target/ src/com/can/*.java
```

#### Run main
```shell
java -cp target/ -Djava.library.path=target/ com.can.Main
```
