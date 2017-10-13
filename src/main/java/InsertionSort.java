/**
 * Created by akumar6 on 6/21/17.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] sampleArray = new int[]{15,18,11,10,8,9,21,22,12,13};
        System.out.println(sampleArray.length);
        insertionSort(sampleArray, 10);
    }

    private static void insertionSort(int[] sampleArray, int size) {
        for (int i=0; i<size ; i++){
            int j = i;
            while (j>0 && sampleArray[j] < sampleArray[i]){
                swap(sampleArray, sampleArray[i],sampleArray[j]);
            }
        }

    }

    private static void swap(int[] sampleArray, int i, int j) {
        int temp = sampleArray[i];
        sampleArray[i] = sampleArray[j];
        sampleArray[j] = temp;
    }
}
