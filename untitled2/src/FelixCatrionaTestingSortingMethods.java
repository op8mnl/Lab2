import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;


public class FelixCatrionaTestingSortingMethods {
    public static void main(String[] args) {
        printHeader();
        int sz = 50000;
        Integer[] list = new Integer[sz];
        for(int i=0; i<list.length;i++){ //fill Integer array with random numbers from 1 to the size the array
            Integer num = (int)(Math.random() * sz + 1);
            list[i]= num;
        }
        Integer[] backup = new Integer[sz]; //creates a backup array
        System.arraycopy(list, 0,backup, 0, sz);
        Integer[] backup2 = new Integer[sz];//creates another backup array
        System.arraycopy(list, 0,backup2, 0, sz);
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(list));
        System.out.println("Testing execution time of different sorting algorithms for sorting 50000 random numbers:");
        long startCollection = System.nanoTime();
        Collections.sort(arr); //collection sort the ArrayList
        long finishCollection = System.nanoTime();
        System.out.printf("Collections' Sorting Time: %.2f milliseconds%n", (((double)(finishCollection)-startCollection)/1000000)); //prints out time taken for Collections sort
        list = backup;
        System.out.printf("My Selection-Sort Time: %.2f milliseconds%n", (double)selectionSort(list)/1000000);//prints out time taken for selection sort
        list= backup;
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds%n", (double)bubbleSort(list)/1000000);//prints out time taken for bubble sort
        list= backup2;
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds%n", (double)insertionSort(list)/1000000);//prints out time taken for insertion sort
        list= backup;
        System.out.printf("My Merge-Sort Time: %.2f milliseconds%n", (double)mergeSort(list)/1000000);//prints out time taken for merge sort
        list= backup;
        System.out.printf("My Quick-Sort Time: %.2f milliseconds%n", (double)quickSort(list,0,sz-1)/1000000);//prints out time taken for quick sort
        list= backup;
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds%n", (double)bucketSort(list,0,sz-1,5)/1000000);//prints out time taken for bucket sort
        printFooter();
    }

    /**
     * Selection Sort Generic Method (Iterative)
     *
     * @param a Generic-type array of any size
     * @return Time elapsed in nanoseconds
     */

    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long start = System.nanoTime();
        for (int i = 0; i < a.length - 1; i++) { //sets the first element as the minimum values
            int minIndex =i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex].compareTo(a[j]) > 0) {//compares with all the elements from left to right if there is a smaller value, switches places
                    minIndex =j;
                    T temp = a[minIndex];
                    a[minIndex] = a[j];
                    a[j] = temp;
                }
            }
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Bubble Sort Method (Generic, Iterative & Ascending)
     *
     * @param a Generic-type array of any size
     * @return Time elapsed in nanoseconds
     */
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long start = System.nanoTime();
        for (int i = 1; i < a.length; i++) { //starts at the element 0 and compares with the element on its right
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {//swap places if the element to the right is less than the element on the left
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Insertion Sort Method (Generic)
     *
     * @param a   Generic-type array of any size
     * @return Time elapsed in nanoseconds
     */
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long start = System.nanoTime();
        for(int i=1; i<a.length;i++){ //compare the first element in array to all the elements from left to right
            T key = a[i];
            for(int j=i-1; j>=0 && a[j].compareTo(key)>0; j--){ //if the element is greater than the first element, a swap occurs
                a[j+1]=a[j];
                a[j] = key;
            }
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Merge Sort Method (Generic & Recursive)
     *
     * @param S Generic-type array of any size
     * @return Time elapsed in nanoseconds
     */
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long start = System.nanoTime();
        int n = S.length;
        if (n < 2) return 0; // array is trivially sorted
        // divide
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half
        // merge sorted halves back into original
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
        long finish = System.nanoTime();
        return finish - start;

    }

    /**
     * Quick Sort Method (Generic)
     *
     * @param s Generic-type array of any size
     * @param a Index a
     * @param b Index b
     * @return Time elapsed in nanoseconds
     */
    //Generic Quick Sort
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long startTime = System.nanoTime();
        if(a >= b){
            return System.nanoTime() - startTime;
        }
        int l = a; //left index
        int r = b; //right index
        T pivot = s[(a+b)/2]; //pivot at midway point
        T temp;

        while(l<=r){//while left is smaller or equal to right index
            while(s[l].compareTo(pivot)<0){
                l++;//when element at left is smaller than the pivot, increase the left index
            }
            while(s[r].compareTo(pivot)>0){
                r--;//when element at right is greater than the pivot, decrease the right index
            }
            if(l<=r){
                temp = s[l]; //switches the left and the right element
                s[l] = s[r];
                s[r] = temp;
                l++;//increase left index by 1
                r--;//decrease right index by 1
            }
        }
        quickSort(s,a,l-1); //call quicksort for left side of array
        quickSort(s,l+1,b);//call quicksort for right side of array
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


    /**
     * Bucket Sort Method (Optional & Not Generic)
     * @param a Integer array
     * @param first index of the first number
     * @param last index of the last number
     * @param maxDigits the number of digits in the longest integer
     * @return Time elapsed in nanoseconds
     */
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long start = System.nanoTime();

        //positive numbers only
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long finish = System.nanoTime();
        return (finish - start);

    }

    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }


    //when called will print the header
    public static void printHeader (){
        System.out.println("\n*******************************************************\n" +
                "Names: Felix Zheng and Catriona Chan.\n"+
                "Student Numbers: 251167970 and 251135537\n" +
                "Goal of this project: Compare the time for different sorting algorithms \nincluding Insertion Sort, Merge Sort, Selection Sort, Quick Sort and Bubble Sort"+
                "\n*******************************************************\n");
    }

    //when called will print the footer message
    public static void printFooter (){
        // prints the following when called
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime today = LocalTime.now();
        String timeString = today.format(formatter);
        System.out.println("\n******************************************************* \n"+
                "This is "+ timeString + " on " + java.time.LocalDate.now() +
                ".\nCompletion of Lab Assignment 2 is successful!\n" +
                "Good bye! Catriona Chan and Felix Zheng." +
                "\n*******************************************************");
    }
}
