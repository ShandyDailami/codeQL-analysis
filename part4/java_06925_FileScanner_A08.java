import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class java_06925_FileScanner_A08 {
    private static final Set<String> sensitiveWords = new HashSet<>();
    private static final Map<String, Set<String>> fileWordCount = new HashMap<>();

    static {
        sensitiveWords.add("sensitive1");
        sensitiveWords.add("sensitive2");
        // You can add more sensitive words here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                Set<String> wordSet = fileWordCount.get(file.getName());
                if (wordSet == null) {
                    wordSet = new HashSet<>();
                    fileWordCount.put(file.getName(), wordSet);
                }

                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    for (String word : line.split("\\s+")) {
                        if (word.length() > 0 && word.matches("^[A-Za-z0-9]*$")) { // Assuming words can contain only alphanumeric characters
                            word = word.toLowerCase();
                            if (sensitiveWords.contains(word)) {
                                wordSet.add(word);
                            }
                        }
                    }
                }
                fileScanner.close();
            }
        }

        for (Map.Entry<String, Set<String>> entry : fileWordCount.entrySet()) {
            System.out.println("File: " + entry.getKey());
            for (String word : entry.getValue()) {
                System.out.println("Word: " + word);
            }
        }
    }
}