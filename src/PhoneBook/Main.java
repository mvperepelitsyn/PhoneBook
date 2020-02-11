package PhoneBook;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int foundSuc;
        DiffrentTimes diffTime = new DiffrentTimes();
        long timeParse, timeLinear = 0, timeBubbleSortAndJumpSearch;
        String[] dirArray;
        String[] findArray;
        //timeParse = System.currentTimeMillis();
        findArray = Parsing.gimmeThatArray(true);
        dirArray = Parsing.gimmeThatArray(false);
        //TimeController.printTheTime(timeParse, "Parsing. ");
        diffTime.timeLinear = System.currentTimeMillis();
        System.out.println("Start searching (linear search)...");
        foundSuc = Searches.linearSearch(findArray, dirArray);
        diffTime.timeLinear = TimeController.doTheTime(diffTime.timeLinear);
        System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
        TimeController.printTheTime(diffTime.timeLinear, "Time taken");
        System.out.println();
        diffTime.timeBubbleSort = System.currentTimeMillis();
        foundSuc = Searches.jumpSearch(findArray, dirArray, diffTime);
        if (diffTime.timeJumpSearch == -1) {
            System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
            TimeController.printTheTime(diffTime.timeBubbleSort + diffTime.timeLinear, "Time taken");
            TimeController.printFailedSortTime(diffTime.timeBubbleSort);
            TimeController.printTheTime(diffTime.timeLinear, "Searching time");
        } else {
            System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
            TimeController.printTheTime(diffTime.timeBubbleSort + diffTime.timeJumpSearch, "Time taken");
            TimeController.printTheTime(diffTime.timeBubbleSort, "Sorting time");
            TimeController.printTheTime(diffTime.timeJumpSearch, "Searching time");
        }
        System.out.println("\n" + "Start searching (quick sort + binary search)...");
        diffTime.timeQuickSort = System.currentTimeMillis();
        Searches.quickSort(dirArray, 0, dirArray.length - 1);
        diffTime.timeQuickSort = TimeController.doTheTime(diffTime.timeQuickSort);
        diffTime.timeBinarySearch = System.currentTimeMillis();
        foundSuc = Searches.binarySearch(findArray, dirArray);
        diffTime.timeBinarySearch = TimeController.doTheTime(diffTime.timeBinarySearch);
        System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
        TimeController.printTheTime(diffTime.timeQuickSort + diffTime.timeBinarySearch, "Time taken");
        TimeController.printTheTime(diffTime.timeQuickSort, "Sorting time");
        TimeController.printTheTime(diffTime.timeBinarySearch, "Searching time");

    }
}