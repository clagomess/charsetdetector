# charset-detector
### Usage
Install local Maven: `mvn clean install`

Add as depedency:
```xml
<dependency>
    <groupId>com.github.clagomess</groupId>
    <artifactId>charset-detector</artifactId>
    <version>[1.0.0,)</version>
</dependency>
```

Code:
```java
log.info("Result: {}", CharsetDetectorUtil.detect("Ação Açucar"));
```
