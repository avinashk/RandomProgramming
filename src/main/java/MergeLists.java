/**
 * Created by akumar6 on 7/31/17.
 */
public class MergeLists {

    public static void main(String args[]) {
        Integer[] list1 = {2, 5, 8, 10, 11, 13};
        Integer[] list2 = {3, 9, 14, 18, 20, 21};

        Integer[] mergedList = mergeList(list1, list2);
        printArray(mergedList);
        mergedList = mergeList(null, null);
        printArray(mergedList);
        mergedList = mergeList(new Integer[]{1}, new Integer[]{2});
        printArray(mergedList);
        mergedList = mergeList(new Integer[]{1}, null);
        printArray(mergedList);
        mergedList = mergeList(null, new Integer[]{1});
        printArray(mergedList);


    }

    private static void printArray(Integer[] mergedList) {
        for (int i = 0; i < mergedList.length; i++) {
            System.out.print(mergedList[i] + "\t");
        }
        System.out.println("\n**********\n");
    }

    private static Integer[] mergeList(Integer[] list1, Integer[] list2) {
        if (list1 == null && list2 == null) {
            return new Integer[0];
        }
        if (list1 == null || list1.length == 0){
            return list2;
        }
        if (list2 == null || list2.length == 0){
            return list1;
        }
        Integer[] mergedList = new Integer[(list1.length + list2.length)];
        for (int i = 0, j = 0, k = 0; i < list1.length || j < list2.length; ) {
            if(j == list2.length){
                mergedList[k] = list1[i];
                i++;
            }
            else if(i == list1.length){
                mergedList[k] = list2[j];
                j++;
            }
            else if (list1[i] > list2[j]) {
                mergedList[k] = list2[j];
                j++;
            }
            else if (list1[i] == list2[j]) {
                mergedList[k] = list1[i];
                k++;
                mergedList[k] = list2[j];
                i++;
                j++;
            }
            else if (list1[i] < list2[j]) {
                mergedList[k] = list1[i];
                i++;
            }
            k++;
        }
        return mergedList;
    }


}
