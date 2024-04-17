
/*You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 70
Output: true*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interview {
    int target = 3;

    public static boolean targetExists(List<List<Integer>> input, int target) {
        int mylist = -1;
        for (int i = 0; i < input.size(); i++) {
            //  System.out.println(input.get(i).get(input.get(i).size()-1));
            if (input.get(i).get(input.get(i).size() - 1) >= target) {
                mylist = i;
                break;
            }
        }
        //   System.out.println(mylist+"mylist");
        if (mylist < 0)
            return false;
        List<Integer> targetList = input.get(mylist);

        //  if(targetList.contains(target)){
        //  return true;
        // int end = mylist;
        if (getIndex(0, targetList.size() - 1, target, targetList) > 0)
            return true;
        //  }
        return false;
    }

    public static int getIndex(int start, int end, int target, List<Integer> targetList) {
        int middleIndex = start + (end - start) / 2;
        if (start > end) return -1;
        if (targetList.get(middleIndex) > target) {
            return getIndex(start, middleIndex - 1, target, targetList);
        } else if (targetList.get(middleIndex) < target)
            return getIndex(middleIndex + 1, end, target, targetList);
        else if (targetList.get(middleIndex) == target)
            return middleIndex;
        return -1;
    }

    public static List<Integer> getList(int start, int end, int target, List<List<Integer>> input ){
        if(start > end) return new ArrayList<>(null);
        int middleList = start + (end-start)/2;
        if(input.get(middleList).get(input.get(middleList).size()-1) > target)
            return getList(middleList+1,end,target,input);
        return new ArrayList<>(null);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n]; // Calculate the midElement using row = mid / n and col = mid % n

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
      /*  List<List<Integer>> input = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        Collections.addAll(list1, 1, 3, 5, 7);
        input.add(list1);
        Collections.addAll(list2, 10, 11, 16, 20);
        input.add(list2);
        Collections.addAll(list3, 23, 30, 34, 60);
        input.add(list3);
        int target = 20;

        System.out.println(targetExists(input, target)); */
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 70;
        System.out.println(searchMatrix(matrix, target));

    }

}
