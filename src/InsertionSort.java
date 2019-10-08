import java.util.Arrays;

public class InsertionSort {

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

                    insertionSort(testingList);



                }

            }



        }




    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
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
            System.out.println("||   Insertion sort test   ||");
            int inputSize = 10;
            int[] testList = createRandomIntegerList(inputSize);


            System.out.println("Unsorted: ");
            System.out.println(Arrays.toString(testList));

            insertionSort(testList);

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




