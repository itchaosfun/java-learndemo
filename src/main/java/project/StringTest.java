package project;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class StringTest<AnyType> {

    private List<AnyType>[] theList;

    public void test() {
        String word = "helloworld";
        String rep = word.substring(0, 1) + word.substring(2);

        System.out.println("rep = " + rep);

        List<AnyType> [] oldList = theList;

        theList[1] = new LinkedList<>();
    }
}
