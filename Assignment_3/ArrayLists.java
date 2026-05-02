package Assignment_3;

import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args){
        ArrayList<Integer> aList = new ArrayList<>();

        aList.add(100);
        aList.add(200);

        for( int i=0; i<=50; i+=5){
            aList.add(i);
            System.out.println(aList.size());
            System.out.println(aList);

            for (int j : aList) {
                System.out.println(aList.indexOf(25));
            }
        }
    }
}
