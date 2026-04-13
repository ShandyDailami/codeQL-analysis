import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_26637_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (directory.isFile()) {
            System.out.println("Entered path is not a directory");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in the directory");
            return;
        }

        // Use Java 8 Streams to sort the files by their names
        Arrays.stream(files).sorted((f1, f2) -> f1.getName().compareTo(f2.getName())).forEach(System.out::println);
    }
}