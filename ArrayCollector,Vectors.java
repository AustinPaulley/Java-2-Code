import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Project1 {

static int[] array = new int[5000000];
static ArrayList<Integer> arrayList = new ArrayList<Integer>();
static Vector<Integer> vector = new Vector<Integer>();

public static void main(String[] args) {

    //create array arraylist and vector

    for (int i = 0; i < 5000000; i++) {
        array[i] = i;
        arrayList.add(i);
        vector.add(i);
    }
// Array
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 5000000; i++) {
        array[i] = i;
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Array: " + (endTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    Arrays.sort(array);
    endTime = System.currentTimeMillis();
    System.out.println("Array Sort: " + (endTime - startTime) + "ms");

// ArrayList
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 5000000; i++) {
        arrayList.add(i);
    }
    endTime = System.currentTimeMillis();
    System.out.println("ArrayList: " + (endTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    Collections.sort(arrayList);
    endTime = System.currentTimeMillis();
    System.out.println("ArrayList Sort: " + (endTime - startTime) + "ms");

// Vector
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 5000000; i++) {
        vector.add(i);
    }
    endTime = System.currentTimeMillis();
    System.out.println("Vector: " + (endTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    Collections.sort(vector);
    endTime = System.currentTimeMillis();
    System.out.println("Vector Sort: " + (endTime - startTime) + "ms");

}}