import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_07894_FileScanner_A08 {
    public static void main(String[] args) {
        File rootDirectory = new File("/path/to/directory");
        String fileExtension = "txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename to search: ");
        String fileName = scanner.nextLine();

        File[] files = rootDirectory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.getName().equals(fileName))
                    .forEach(file -> System.out.println("File Found: " + file.getAbsolutePath()));
        } else {
            System.out.println("No files found with extension: " + fileExtension);
        }

        scanner.close();
    }
}