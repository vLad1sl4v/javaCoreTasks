package by.incubator.myHashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductAccount {
    public int mostFrequent(HashMap<String, Integer> hashMap) {
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        int maxValue = 0;

        for (Map.Entry<String, Integer> entry : set) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
            }
        }

        return maxValue;
    }
}
