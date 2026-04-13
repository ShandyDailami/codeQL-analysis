import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37561_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension (e.g., .txt):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found with that extension.");
        } else {
            System.out.println("Files with the extension " + fileExtension + ":");
            Arrays.stream(files).map(File::getName).forEach(System.out::println);
        }

        scanner.close();
    }
}