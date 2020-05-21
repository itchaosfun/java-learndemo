package project;

import java.util.*;

public class RecombineTest {


    private List<Recombine> beforeList = new ArrayList<>();

    public void testRecombine() {
        generalList();

        startRecombine();


    }

    private void startRecombine() {
        HashMap<Integer, Recombine> afterHashMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString() + System.currentTimeMillis();;
        for (Recombine recombine : beforeList) {
            if (!afterHashMap.containsKey(recombine.age)) {
                recombine.name = String.format("「%s」", recombine.name);
                afterHashMap.put(recombine.age, recombine);
            } else {
                Recombine recombine1 = afterHashMap.get(recombine.age);
                String name = recombine1.name;
                String regex = String.format("、%s「",uuid);
                String[] split = name.split(regex);
                if (split.length <= 2) {
                    if (split.length == 2) {
                        //此处使用uuid是为了避免用户名中含有“、「”之后被错误拆分的问题
                        recombine1.name = String.format("%s、%s「%s」等", recombine1.name, uuid,recombine.name);
                    } else {
                        recombine1.name = String.format("%s、%s「%s」", recombine1.name, uuid,recombine.name);
                    }
                    afterHashMap.replace(recombine.age, recombine1);
                }
            }
        }

        List<Recombine> afterList = new ArrayList<>();

        Set<Map.Entry<Integer, Recombine>> entries = afterHashMap.entrySet();
        for (Map.Entry<Integer, Recombine> entry : entries) {
            Recombine recombine = entry.getValue();
            String name = recombine.name;
            System.out.println(String.format("before replace %s",name));
            recombine.name = name.replace(uuid, "");
            afterList.add(recombine);
        }

        for (Recombine recombine : afterList) {
            System.out.println(recombine.toString());
        }

    }

    private void generalList() {

        beforeList.add(new Recombine("zhangsan、「", 23, "qq"));
        beforeList.add(new Recombine("lisi", 24, "ww"));
        beforeList.add(new Recombine("wangwu", 25, "ee"));
        beforeList.add(new Recombine("liuliu", 26, "rr"));
        beforeList.add(new Recombine("chenqi", 27, "tt"));
        beforeList.add(new Recombine("huba", 28, "yy"));
        beforeList.add(new Recombine("zhaojiu", 29, "uu"));

        beforeList.add(new Recombine("zhangxiaosan", 23, "q"));
        beforeList.add(new Recombine("lixiaosi", 24, "w"));
        beforeList.add(new Recombine("wangxiaowu", 25, "e"));
        beforeList.add(new Recombine("liuxiaoliu、「", 26, "r"));
        beforeList.add(new Recombine("chenxiaoqi", 27, "t"));
        beforeList.add(new Recombine("huxiaoba", 28, "y"));
        beforeList.add(new Recombine("zhaoxiaojiu", 29, "u"));

        beforeList.add(new Recombine("zhangdasan", 23, "qqqq"));
        beforeList.add(new Recombine("lidasi", 24, "wwww"));
        beforeList.add(new Recombine("wangdawu", 25, "eeee"));
        beforeList.add(new Recombine("liudaliu", 26, "rrrr"));
        beforeList.add(new Recombine("chendaqi、「", 27, "tttt"));
        beforeList.add(new Recombine("hudaba", 28, "yyyy"));
        beforeList.add(new Recombine("zhaodajiu", 29, "uuuu"));

        beforeList.add(new Recombine("zhangzhongsan", 23, "qqq"));
        beforeList.add(new Recombine("lizhongsi", 24, "www"));
        beforeList.add(new Recombine("wangzhongwu", 25, "eee"));
        beforeList.add(new Recombine("liuzhongliu", 26, "rrr"));
        beforeList.add(new Recombine("chenzhongqi", 27, "ttt"));
        beforeList.add(new Recombine("huzhongba", 28, "yyy"));
        beforeList.add(new Recombine("zhaozhongjiu", 29, "uuu"));


    }

}

class Recombine {
    String name;
    int age;
    String hobby;

    public Recombine(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "project.Recombine{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}


