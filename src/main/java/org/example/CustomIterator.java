package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomIterator implements Iterator<String> {
    private List<Iterator<String>> iterators;
    private List<List<String>> originalLists;
    private String[] currentValues;
    private boolean hasNext;

    public CustomIterator(List<String> list1, List<String> list2, List<String> list3) {
        originalLists = Arrays.asList(list1, list2, list3);
        iterators = new ArrayList<>();
        originalLists.forEach(list -> iterators.add(list.iterator()));
        currentValues = new String[iterators.size()];
        hasNext = true;

        for (int i = 0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext()) {
                currentValues[i] = iterators.get(i).next();
            } else {
                hasNext = false;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }

        String result = String.join("", currentValues);

        for (int i = iterators.size() - 1; i >= 0; i--) {
            if (iterators.get(i).hasNext()) {
                currentValues[i] = iterators.get(i).next();
                break;
            } else {
                if (i == 0) {
                    hasNext = false;
                } else {
                    iterators.set(i, originalLists.get(i).iterator());
                    currentValues[i] = iterators.get(i).next();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("a", "b", "c");
        List<String> list3 = Arrays.asList("a", "b", "c");

        CustomIterator customIterator = new CustomIterator(list1, list2, list3);

        int count = 0;
        while (customIterator.hasNext()) {
            count++;
            System.out.println(customIterator.next());
        }

        System.out.println("count:"+count);
    }
}
