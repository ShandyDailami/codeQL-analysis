import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_09897_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        Set<String> uniqueFiles = new HashSet<>();
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        uniqueFiles.add(file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        System.out.println("Unique files in directory:");
        for (String fileName : uniqueFiles) {
            System.out.println(fileName);
        }
    }
}