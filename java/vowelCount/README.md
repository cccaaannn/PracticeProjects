## Vowel count

#### Bit mask speed test

### Results
```
Generating 10,000,000 words with 5 characters...
Counting words with vowels...
Baseline: 6,563,768 vowels in 699 ms
Bit mask realtime: 6,563,768 vowels in 80 ms
Bit mask lookup array: 6,563,768 vowels in 90 ms
Bit mask lookup map: 6,563,768 vowels in 136 ms
```

### Compile
```shell
javac -d target/ src/com/can/*.java
```

#### Run main
```shell
java -cp target/ com.can.Main
```
