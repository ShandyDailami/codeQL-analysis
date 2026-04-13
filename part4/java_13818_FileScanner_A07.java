import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_13818_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File(".");
        Map<String, Integer> fileLineCounts = new HashMap<>();

        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (isAuthFailureFileName(fileName)) {
                        try (Scanner scanner = new Scanner(file)) {
                            int lineCount = 0;
                            while (scanner.hasNextLine()) {
                                scanner.nextLine();
                                lineCount++;
                            }
                            fileLineCounts.put(fileName, lineCount);
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : fileLineCounts.entrySet()) {
            System.out.println("File: " + entry.getKey() + ", Lines: " + entry.getValue());
        }
    }

    private static boolean isAuthFailureFileName(String fileName) {
        return Pattern.matches(".*A07_AuthFailure.*", fileName);
    }
}