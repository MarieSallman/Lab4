import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class BubbleSort {
    static int MAXSIZE = 100;
    static int MINSIZE = 10;
    static long MAXVALUE = 2000;
    static long MINVALUE = -2000;
    static long numberOfTrials = 10;
    static int SIZEINC = 1000;

    public static void main(String[] args) {

        checkSortCorrectness();

        /* For each size of input that we want to test */
        for (int inputSize = MINSIZE; inputSize <= MAXSIZE; inputSize = inputSize + SIZEINC) {


            for (long trial = 0; trial < numberOfTrials; trial++) {
                /* For one trial: */
                /* generate (random?) input data of desired size (a list of N random numbers) */
                long[] testingList = createRandomIntegerList(inputSize);


                /* apply test function to the test input */

                bubbleSortNumberList(testingList);



            }

        }

    }

    /* return the index of the searched number if found or -1 if not found */
    public static void bubbleSortNumberList(long[] list) {
        /* make N passes through the list (N is the length of the list) */
        for (int i = 0; i < list.length; i++) {
            /* for index from 0 to N-1 compare item[index] to next item, swap if needed */
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    long tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
    }

    public static long[] createRandomIntegerList(int size) {

        long[] newList = new long[size];
        for (int j = 0; j < size; j++) {
            newList[j] = (long) (MINVALUE + Math.random() * (MAXVALUE - MINVALUE));
        }
        return newList;
    }

    public static void checkSortCorrectness(){
        System.out.println("||   Bubble sort test   ||");
        int inputSize = 10;
        long[] testList = createRandomIntegerList(inputSize);

        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(testList));

        bubbleSortNumberList(testList);

        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(testList));

        System.out.println("The list has been correctly sorted: ");

        if (verifySorted(testList) == true){
            System.out.println("True");
        }else{System.out.println("False");}
    }

    public static boolean verifySorted(long[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
