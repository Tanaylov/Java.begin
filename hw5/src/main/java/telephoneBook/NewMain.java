package telephoneBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class NewMain {
    public static void main(String[] args) throws IOException {
        TreeMap<String, HashSet<Long>> phoneBookTMap = new TreeMap<>();
        String telBookFile = "Phone_Book.txt";
        BufferedReader br = new BufferedReader(new FileReader(telBookFile));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            if (phoneBookTMap.containsKey(strArr[0])) {
                if (!phoneBookTMap.get(strArr[0]).add(Long.parseLong(strArr[1])))
                    phoneBookTMap.put(strArr[0] + " repeat", new HashSet<>(Arrays.asList(Long.parseLong(strArr[1]))));
                else phoneBookTMap.get(strArr[0]).add(Long.parseLong(strArr[1]));
            } else phoneBookTMap.put(strArr[0], new HashSet<>(Arrays.asList(Long.parseLong(strArr[1]))));
        }
        br.close();
        System.out.println("phoneBookTMap = " + phoneBookTMap);
    }
}
