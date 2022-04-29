package by.incubator.myHashTable;

import java.util.*;

public class MyHashTableDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> productMap = initHashTable();
        ProductAccount account = new ProductAccount();

        System.out.println("Quantity of most frequent product: " + account.mostFrequent(productMap));

        Set<String> productSet = new HashSet<>(productMap.keySet());
        addNewProducts(productSet);
        showProducts(productSet);
    }

    private static void addNewProducts(Set<String> productSet) {
        productSet.add("Sweets");
        productSet.add("Chocolate");
        productSet.add("Cookies");
        productSet.add("Marmalade");
    }

    private static void showProducts(Set<String> hashSet) {
        System.out.println("All products that we have: ");
        for (String product : hashSet) {
            System.out.print(product + " ");
        }
    }

    private static HashMap<String, Integer> initHashTable() {
        HashMap<String, Integer> hashTable = new HashMap<>();

        hashTable.put("Milk", 37);
        hashTable.put("Bread", 45);
        hashTable.put("Salad", 47);
        hashTable.put("Broccoli", 67);
        hashTable.put("Pears", 43);
        hashTable.put("Pineapples", 31);
        hashTable.put("Butter", 54);

        return hashTable;
    }
}
