import java.util.Arrays;

public class MergeSort {

    static int MAXSIZE = 100;
    static int MINSIZE = 10;
    static int MAXVALUE = 2000;
    static int MINVALUE = -2000;
    static int numberOfTrials = 10;
    static int SIZEINC = 1000;

    public static void main(String[] args) {
        checkSortCorrectness();

        for (int inputSize = MINSIZE; inputSize <= MAXSIZE; inputSize = inputSize + SIZEINC) {


            for (int trial = 0; trial < numberOfTrials; trial++) {
                /* For one trial: */
                /* generate (random?) input data of desired size (a list of N random numbers) */
                int[] testingList = createRandomIntegerList(inputSize);


                /* apply test function to the test input */

                mergeSort(testingList, testingList.length);



            }

        }



    }




    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static int[] createRandomIntegerList(int size) {

        int[] newList = new int[size];
        for (int j = 0; j < size; j++) {
            newList[j] = (int)(MINVALUE + Math.random() * (MAXVALUE - MINVALUE));
        }
        return newList;
    }

    public static void checkSortCorrectness(){
        System.out.println("||   Merge sort test   ||");
        int inputSize = 10;
        int[] testList = createRandomIntegerList(inputSize);


        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(testList));

        mergeSort(testList, testList.length);

        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(testList));

        System.out.println("The list has been correctly sorted: ");

        if (verifySorted(testList) == true){
            System.out.println("True");
        }else{System.out.println("False");}
    }

    public static boolean verifySorted(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }



}
