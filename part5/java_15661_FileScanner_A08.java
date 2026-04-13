import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15661_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        System.out.println("Enter the file extension to search:");
        String extension = scanner.nextLine();

        File dir = new File(path);
        File[] listOfFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            Arrays.stream(listOfFiles)
                    .forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}