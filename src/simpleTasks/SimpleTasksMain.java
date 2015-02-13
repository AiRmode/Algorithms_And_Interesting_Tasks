package simpleTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by alshevchuk on 11.02.2015.
 */
public class SimpleTasksMain {

    public static void main(String[] args) {
        euclidsCommonDividerRun();
        maxElemInArrayRun();
        reverseElementsRun();
        isPrimeRun();
        uniformRun();
        binarySearchRun();
        bubbleSortRun();
        fibonachiRun();
    }

    private static void fibonachiRun() {
        int N = 15;
        List<Integer> fibo = calcNFirstFibonachi(N);
        System.out.println("Fibonachi: " + fibo.toString());
    }

    private static List<Integer> calcNFirstFibonachi(int n) {
        List<Integer> result = new ArrayList<>(n);
        int current = 0;
        int next = 1;
        result.add(current);
        result.add(next);
        while (n > 0) {
            int fibo = current + next;
            current = next;
            next = fibo;
            n--;
            result.add(fibo);
        }
        return result;
    }

    private static void bubbleSortRun() {
        Integer[] srcArray = {
                100, 1, 22, 6, 8, 3, 9, 33, 48, 5, 17, 19, 3, 4, 98
        };
        System.out.println("SrcArray: " + Arrays.asList(srcArray));
        bubbleSort(srcArray);
        System.out.println("SrcArray: " + Arrays.asList(srcArray));
    }

    private static void bubbleSort(Integer[] srcArray) {
        int temp;
        for (int i = 1; i < srcArray.length; i++) {
            for (int j = 1; j < srcArray.length; j++) {
                if (srcArray[j - 1] > srcArray[j]) { //swap them
                    temp = srcArray[j - 1];
                    srcArray[j - 1] = srcArray[j];
                    srcArray[j] = temp;
                }
            }
        }
    }

    private static void binarySearchRun() {
//        Integer[] srcArray = {
//                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 88, 99, 100, 122, 123, 144
//        };
        Integer[] srcArray = {
                10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98
        };
        Integer goal = 57;
        System.out.println("Source array: " + Arrays.asList(srcArray));
        Integer element = binarySearch(srcArray, goal);
        System.out.println("Goal: " + goal + " Found: " + element);
    }

    private static Integer binarySearch(Integer[] srcArray, Integer goal) {
        Integer[] arrayPart;
        Integer middle;
        Integer startIndex = 0;
        Integer lastIndex = srcArray.length - 1;

        Integer midIndex = (lastIndex - startIndex) / 2;
        middle = srcArray[midIndex];

        while (middle != goal) {
            if (goal > middle) {
                startIndex = midIndex + 1;
                midIndex = startIndex + ((lastIndex - startIndex) / 2);
                middle = srcArray[midIndex];

                arrayPart = new Integer[lastIndex - startIndex + 1];
                System.arraycopy(srcArray, startIndex, arrayPart, 0, lastIndex - startIndex + 1);
                System.out.println("start: " + startIndex + " middle: " + midIndex + " last: " + lastIndex + " Array: " + Arrays.asList(arrayPart));
            } else { //goal < middle
                lastIndex = midIndex - 1;
                midIndex = startIndex + ((lastIndex - startIndex) / 2);
                middle = srcArray[midIndex];

                arrayPart = new Integer[lastIndex - startIndex + 1];
                System.arraycopy(srcArray, startIndex, arrayPart, 0, lastIndex - startIndex + 1);
                System.out.println("start: " + startIndex + " middle: " + midIndex + " last: " + lastIndex + " Array: " + Arrays.asList(arrayPart));
            }
        }
        return middle;
    }

    private static void uniformRun() {
        double a = 5;
        double b = 10;
        double c = uniform(a, b);
        System.out.println("[ " + a + ", " + b + " ) = " + c);


    }

    private static double uniform(double a, double b) {
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        double rnd = r.nextDouble();
        return a + rnd * (b - a);
    }

    private static void isPrimeRun() {
        int i = 17;
        System.out.println("Is prime " + i + " : " + isPrime(i));
    }

    private static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i < N; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    private static void reverseElementsRun() {
        Integer[] srcArray = {1, 2, 3, 4, 5};
        System.out.println("Src array: " + Arrays.asList(srcArray));
        Integer[] reversed = reverseArray(srcArray);
        System.out.println("Reversed: " + Arrays.asList(reversed));
    }

    private static Integer[] reverseArray(Integer[] srcArray) {
        for (int i = 0; i < srcArray.length / 2; i++) {
            Integer temp = srcArray[i];
            srcArray[i] = srcArray[srcArray.length - 1 - i];
            srcArray[srcArray.length - 1 - i] = temp;
        }
        return srcArray;
    }

    private static void maxElemInArrayRun() {
        int[] srcArray = new int[]{1, 6, 3, 1, 2, 5, 6, 73, 2};
        Integer[] srcArrayWrapper = new Integer[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            srcArrayWrapper[i] = srcArray[i];
        }
        System.out.println("Source array: " + Arrays.asList(srcArrayWrapper));
        System.out.println("Max elem in array = " + maxElemInArray(srcArray));
    }

    private static int maxElemInArray(int[] srcArray) {
        int max = srcArray[0];
        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i] > max) max = srcArray[i];
        }
        return max;
    }

    private static void euclidsCommonDividerRun() {
        int euclidP = 15;
        int euclidQ = 5;
        System.out.println("The highest common divider: for " + euclidP + " and " + euclidQ + " = " + testEuclid(euclidP, euclidQ));
    }

    private static int testEuclid(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return testEuclid(q, r);
    }
}
