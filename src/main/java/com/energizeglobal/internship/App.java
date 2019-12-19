package com.energizeglobal.internship;

import sun.awt.image.ImageWatched;

import java.nio.channels.ScatteringByteChannel;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class App 
{
    private final static String[] STRINGS = {
            "first", "second", "third", "fourth", "and others"
    };

    public static void main(String[] args) {
        try {
            failFast();
        } catch (ConcurrentModificationException ex) {
            System.err.println("We have ConcurrentModificationException in failFast() method.");
        }
        failFree();
        nullsEverywhere();
    compareCars();
    }

    private static void nullsEverywhere() {
        final ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(null);
        final LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
        final TreeSet<Object> treeSet = new TreeSet<>();
        //treeSet.add(null); we can't add null in treeSet,but can do it in HashSet and LinkedHashSet
        final HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, "nully");
        hashMap.put(1, null);
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get(1));

    }

    private static void failFast() {
        final ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(STRINGS));
        final Iterator<String> iterator = stringArrayList.iterator();
        while (iterator.hasNext()) {
            stringArrayList.add("first");
            System.out.println(iterator.next());
        }
        System.out.println(stringArrayList.toString());
    }

    private static void failFree() {
        System.out.println("In failFree() method.");
        System.out.println(Arrays.toString(STRINGS));
        final List<String> stringArrayList = new CopyOnWriteArrayList<>(Arrays.asList(STRINGS));
        final Iterator<String> iterator = stringArrayList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            stringArrayList.add("new");
        }
        System.out.println(stringArrayList.toString());
    }

    private static void compareCars() {
        final ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(1000, 200));
        carList.add(new Car(15000, 1500));
        carList.add(new Car(3500, 450));
        carList.add(new Car(20000, 150));
        carList.add(new Car(2000, 400));
        System.out.println("Car list without sort: " + carList.toString());
        Collections.sort(carList);
        System.out.println("Car list with price sort: " + carList.toString());
        Collections.sort(carList, new Car.HorsePowerComparator());
        System.out.println("Car list with HP sort: " + carList.toString());
    }
}


