package Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class s03_SearchSortTemplate {

    public static void main(String[] args) {
        ArrayList<Integer> list = generateRandomIntegerArrayList();
        printArrayListWithIndexNums(list);
        printArrayListWithIndexNums(InsertionSort(list));
    }

    public static int findIndex(ArrayList<Integer> nums, int target) {
        while (true) {
            ArrayList<Integer> leftHalf = new ArrayList<>();
            ArrayList<Integer> rightHalf = new ArrayList<>();
            for (int i = 0; i < nums.size() / 2; i++) {
                leftHalf.add(nums.get(i));
            }
            for (int i = nums.size() / 2; i < nums.size(); i++) {
                rightHalf.add(nums.get(i));
            }
            if (leftHalf.get(leftHalf.size()) == target) {
                return leftHalf.size();
            }
            if (leftHalf.get(leftHalf.size()) > target) {
                return 1;
            }
            if (leftHalf.get(rightHalf.size()) == target) {
                return rightHalf.size() + leftHalf.size();
            }
            if (leftHalf.get(leftHalf.size()) < target || leftHalf.get(rightHalf.size()) > target) {
                return 0;
            }
        }
    }

    public static ArrayList<Integer> InsertionSort(ArrayList<Integer> nums) {
        int n = nums.size();
        for (int j = 1; j < n; j++){
            int key = nums.get(j);
            int i = j-1;
            while ((i > -1) && (nums.get(i) > key)){
                nums.set(i+1, nums.get(i));
                i--;
            }
            nums.set(i+1, key);
        }
        return nums;
    }

    public static ArrayList<Integer> BubbleSort(ArrayList<Integer> nums) {
        int x = 0;
        while (x < nums.size()) {
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i + 1) < nums.get(i)) {
                    int y = nums.get(i);
                    int z = nums.get(i + 1);
                    nums.set(i, z);
                    nums.set(i + 1, y);
                }
            }
            x++;
        }
        return nums;
    }

    public static ArrayList<Integer> SelectionSort(ArrayList<Integer> nums){
        int x = 0;
        int y = 0;
        while(x < nums.size()-1) {
            int min = nums.get(x);
            for (int i = x + 1; i < nums.size(); i++) {
                if (nums.get(i) < min) {
                    min = nums.get(i);
                    y = i;
                }
            }
            nums.remove(y);
            nums.add(x, min);
            x++;
        }
        return nums;
    }

    public static ArrayList<Integer> generateRandomIntegerArrayList(){
        //Constructs an array with the numbers 10 through 99 in order.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<100; i++){
            list.add((int)(Math.random()*100));
        }
        return list;
    }

    public static void printArrayListWithIndexNums(ArrayList<Integer> list){
        System.out.println(list.toString());
        System.out.print("  ");
        for(int i=0; i<list.size(); i++){
            if(i<9){
                System.out.print(i+",  ");
            }else if(i<=98){
                System.out.print(i+", ");
            }else{
                System.out.print(i+",");
            }
        }
        System.out.println();
    }



}
