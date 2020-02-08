package PhoneBook;

public class Main {

    public static void main(String[] args) {
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
            System.exit(0);
        } else {
            System.out.print("Found " + foundSuc + " / " + findArray.length + " entries. ");
            TimeController.printTheTime(diffTime.timeBubbleSort + diffTime.timeJumpSearch, "Time taken");
            TimeController.printTheTime(diffTime.timeBubbleSort, "Sorting time");
            TimeController.printTheTime(diffTime.timeJumpSearch, "Searching time");
        }
    }
}
