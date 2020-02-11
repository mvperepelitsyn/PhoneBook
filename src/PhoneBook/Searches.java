package PhoneBook;

import java.io.IOException;

public class Searches {

    private static int binaryTheSearch(String[] array, String elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (elem.compareTo(array[mid]) == 0) {
                return mid; // the element is found, return its index
            } else if (elem.compareTo(array[mid]) < 0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }

    static int binarySearch(String[] findArray, String[] dirArray) {
        int foundSuc = 0;
        for (int i = 0; i < findArray.length; i++) {
            if (binaryTheSearch(dirArray, findArray[i], 0, dirArray.length - 1) != -1) {
                foundSuc++;
            }
        }
        return foundSuc;
    }

    private static int partition(String[] array, int left, int right) {
        String pivot = array[right];  // choose the rightmost element as the pivot
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivot) <= 0) { // may be used '<' as well
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void quickSort(String[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // the pivot is already on its place
            quickSort(array, left, pivotIndex - 1);  // sort the left subarray
            quickSort(array, pivotIndex + 1, right); // sort the right subarray
        }
    }


    static String gimmeThatName(String dirStr) {
        String[] nameArray = dirStr.split(" ");
        String nameStr = "";
        for (int i = 1; i < nameArray.length; i++) {
            nameStr = nameStr + nameArray[i];
            if (i + 1 < nameArray.length) {
                nameStr = nameStr + " ";
            }
        }
        return nameStr;
    }

    static int linearSearch(String[] findArray, String[] dirArray) {
        int foundSuc = 0;
        for (int i = 0; i < findArray.length; i++) {
            for (int j = 0; j < dirArray.length; j++) {
                if (findArray[i].equals(dirArray[j])) {//(findArray[i].equals(gimmeThatName(dirArray[j]))) {
                    foundSuc++;
                    break;
                }
            }
        }
        return foundSuc;
    }

    static String[] bubbleSort(String[] array, DiffrentTimes diffTime) throws IOException {
        String tmp;
        long timeTmp = 69;
        timeTmp++;
        for (int i = 0; i < array.length - 1; i++) {
            timeTmp = System.currentTimeMillis() - diffTime.timeBubbleSort;
            if (diffTime.timeLinear * 10 < timeTmp) {
                diffTime.timeBubbleSort = timeTmp;
                return null;
            }
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        diffTime.timeBubbleSort = TimeController.doTheTime(diffTime.timeBubbleSort);
        return array;
    }

    static int jumpSearch(String[] findArray, String[] dirArray, DiffrentTimes diffTime) throws IOException {
        System.out.println("Start searching (bubble sort + jump search)...");
        int foundSuc = 0;
        if (bubbleSort(dirArray, diffTime) == null) {
            diffTime.timeLinear = System.currentTimeMillis();
            foundSuc = linearSearch(findArray, dirArray);
            diffTime.timeLinear = TimeController.doTheTime(diffTime.timeLinear);
            diffTime.timeJumpSearch = -1;
            return foundSuc;
        }
        diffTime.timeJumpSearch = System.currentTimeMillis();
        int step = (int) Math.sqrt(dirArray.length);
        for (int i = 0, prevRight = 0, currentStep = 0; i < findArray.length; i++) {
            while (currentStep < dirArray.length - 1) {
                if (dirArray[currentStep].compareTo(findArray[i]) >= 0) {
                    for (int l = currentStep; l > prevRight; l--) {
                        if (dirArray[l].compareTo(findArray[i]) == 0) {
                            foundSuc++;
                            break;
                        }
                    }
                    break;

                }
                prevRight = currentStep;
                currentStep = Math.min(dirArray.length - 1, currentStep + step);
            }
        }
        diffTime.timeJumpSearch = TimeController.doTheTime(diffTime.timeJumpSearch);
        return foundSuc;
    }
}
