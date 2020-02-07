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
                if (findArray[i].equals(gimmeThatName(dirArray[j]))) {
                    foundSuc++;
                    break ;
                }
            }
        }
        return foundSuc;
    }
}
