package telephoneBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<String, ArrayList<Long>> phoneBookTMap = new TreeMap<>();
        String telBookFile = "Phone_Book.txt";
        BufferedReader br = new BufferedReader(new FileReader(telBookFile));
        String str;
//        long num = 89_052_345_555l;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            if (phoneBookTMap.containsKey(strArr[0])) {
                ArrayList<Long> tempList = phoneBookTMap.get(strArr[0]);
                tempList.add(Long.valueOf(strArr[1]));
                phoneBookTMap.put(strArr[0], tempList);
//                phoneBookTMap.put(strArr[0], phoneBookTMap.get(strArr[0]).add(Long.parseLong(strArr[1])));
            } else phoneBookTMap.put(strArr[0], new ArrayList<>(Arrays.asList(Long.parseLong(strArr[1]))));
        }
        br.close();
        System.out.println("phoneBookTMap = " + phoneBookTMap);
        phoneBookTMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(el -> -el.getValue().size()))
                .forEach(System.out::println);
    }
}