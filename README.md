# AES-128-CBC Example for Java

### Compile java
```
javac -classpath ".:commons-codec-1.12.jar" AESMain.java
```

### Exec java
```
java -classpath ".:commons-codec-1.12.jar" AESMain
-
Key: 485de0e185028e9906e6131aaf210104
IV: c22bd245f41dcace6fb91c2bdf478e0f
data: haha|yeye
encrypted: VaTrJFB1TdXD0niGkczIeA==
decrypted: haha|yeye
```

#### Java Cipher Instance type
```
AES/CBC/NoPadding (128)
AES/CBC/PKCS5Padding (128)
AES/ECB/NoPadding (128)
AES/ECB/PKCS5Padding (128)
```
