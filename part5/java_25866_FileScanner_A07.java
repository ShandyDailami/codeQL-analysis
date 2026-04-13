import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25866_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith("Example"));

            if (files != null) {
                Arrays.stream(files)
                      .map(File::getName)
                      .forEach(System.out::println);
            } else {
                System.out.println("No files found ending with 'Example'.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}