import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_10886_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        List<String> txtFiles = new ArrayList<>();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        txtFiles.add(file.getName());
                    }
                }
            }
        }

        System.out.println("The following txt files found in the directory:");
        txtFiles.forEach(System.out::println);
    }
}