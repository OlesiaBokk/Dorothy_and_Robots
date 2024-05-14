package cy.olesiabokk.dorothyandrobotsapp.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    public String setFileName(StringBuilder text, String regex) {
        String fileName = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            fileName = text.substring(matcher.start(), matcher.end());
        }
        return fileName;
    }

    public String getIdealString(ArrayList<String> list) {
        StringBuilder endString = new StringBuilder();
        List<String> trimList = removeDuplicate(list);
        for (int i = 0; i < trimList.size(); i++) {
            endString.append(trimList.get(i)).append(" ");
        }
        return endString.toString();
    }

    public ArrayList<String> getEvenNumVowelsList(StringBuilder text) {
        ArrayList<String> words = new ArrayList<>();
        for (String str : getTextList(text)) {
            int vowelCount = countVowels(str);
            if (vowelCount % 2 == 0 && vowelCount != 0) {
                words.add(str);
            }
        }
        return words;
    }

    public ArrayList<String> getOddNumVowelsList(StringBuilder text) {
        ArrayList<String> words = new ArrayList<>();
        for (String str : getTextList(text)) {
            int vowelCount = countVowels(str);
            if (vowelCount % 2 != 0) {
                words.add(str);
            }
        }
        return words;
    }

    private List<String> removeDuplicate(ArrayList<String> list) {
        return new ArrayList<>(list.stream().distinct().toList());
    }

    private ArrayList<String> getTextList(StringBuilder text) {
        return new ArrayList<>(Arrays.asList(text.toString()
                .replaceAll("\n", " ")
                .replaceAll("\r", " ")
                .replaceAll("[.,;!]", "")
                .replaceAll("~.+~", "")
                .replaceAll("ao.+\\^p", "")
                .split(" ")));
    }

    private static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<String> countPunctMarks(StringBuilder text) {
        ArrayList<String> resultList = new ArrayList<>();
        char[] charArray = new char[]{'!', ',', '.', ';', ':', '?', '-'};
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (charArray[i] == text.charAt(j)) {
                    count++;
                }
            }
            resultList.add(charArray[i] + " " + count);
            count = 0;
        }
        return resultList;
    }

    public String idealStr(ArrayList<String> strList) {
        StringBuilder endString = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            endString.append(strList.get(i)).append("\n");
        }
        return endString.toString();
    }

    private static boolean isVowel(char ch) {
        return Pattern.matches("[AaEeIiOoUuYy]", String.valueOf(ch));
    }

    public void clearDir(File dirName) {
        File[] content = dirName.listFiles();
        boolean isEmpty = false;
        while (!isEmpty) {
            for (File file : content) {
                if (file.isDirectory()) {
                    deleteDire(file);
                    file.delete();
                } else {
                    file.delete();
                }
            }
            isEmpty = true;
        }
    }

    private static void deleteDire(File dir) {
        File[] dirContent = dir.listFiles();
        boolean isDirEmpty = false;
        while (!isDirEmpty) {
            for (File element : dirContent) {
                element.delete();
            }
            isDirEmpty = true;
        }
    }
}
