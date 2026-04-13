import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_38408_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.next();

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(fileName));

        if (matchingFiles != null) {
            Arrays.stream(matchingFiles)
                    .forEach(file -> System.out.println(file.getPath()));
        } else {
            System.out.println("No files found.");
        }
    }
}