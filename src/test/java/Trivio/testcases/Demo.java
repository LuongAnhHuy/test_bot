package Trivio.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>(Arrays.asList(1,2,3,4,5,1,2,3,4,5));
        List<Integer> items2 = items.stream().distinct().collect(Collectors.toList());


        List<Integer> items3 = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if(items.get(i).equals(items.get(j))){
                    items.remove(j);
                    j--;
                }
            }
        }
        System.out.println(items);
    }
}
