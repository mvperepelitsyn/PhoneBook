package PhoneBook;

public class Searches {

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

    static String[] bubbleSort(String[] array, DiffrentTimes diffTime) {
        String tmp;
        long timeTmp;
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

    static int jumpSearch(String[] findArray, String[] dirArray, DiffrentTimes diffTime) {
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
