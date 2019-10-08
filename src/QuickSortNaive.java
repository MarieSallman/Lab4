import java.util.Arrays;


public class QuickSortNaive {

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

                quickSort(testingList);



            }

        }



    }


    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {

            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;


        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
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
        System.out.println("||   Quick sort naive test   ||");
        int inputSize = 10;
        int[] testList = createRandomIntegerList(inputSize);


        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(testList));

        quickSort(testList);

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