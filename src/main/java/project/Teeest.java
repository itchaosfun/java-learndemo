package project;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Teeest {
    public void test(){
        Stream<String> stringStream = Stream.of("profile=native", "debug=true", "logging=warn", "interval=500");
        HashMap<String, String> stringMap = new HashMap<>();
        Map<String,String> map = stringStream
                .map(kv ->{
                    String[] ss = kv.split("\\=",2);
                    stringMap.put(ss[0],ss[1]);
                    return stringMap;
                }).reduce(stringMap,(m, kv) ->{
                   m.putAll(kv);
                   return m;
                });

        map.forEach((key, value) -> {
            System.out.println("key = " + key + ", value = " + value);
        });
    }
}
