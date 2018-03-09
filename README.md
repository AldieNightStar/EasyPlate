# EasyPlate
```java
String s = "Hello, $[[name]]"
Map model = new HashMap<>();
model.put("name", "World!");
System.out.println( EasyPlate.render(s, model) );
```
