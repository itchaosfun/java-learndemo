package project;

import sun.awt.image.ImageWatched;

import java.util.*;

public class StringTest<AnyType> {

    private List<AnyType>[] theList;

    public void test() {
        Set<List<Integer>> listSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        listSet.add(list);
        for (int i = 0; i < 10; i++) {
            List<Integer> arrayList = new ArrayList<>();
            arrayList.add(i % 2);

            if (listSet.contains(arrayList)){
                System.out.println("listSet contains list, i = " + i);
            }
        }

        System.out.println("listSet size = " + listSet.size());
    }

    public void subTest(){
        String abc = "abcdefghijk+=";

        if (abc.endsWith("==")){
            abc = abc.substring(0, abc.length() - 2);
        }
        if (abc.endsWith("=")){
            abc = abc.substring(0, abc.length() - 1);
        }

        System.out.println("abc = " + abc);
    }
}
