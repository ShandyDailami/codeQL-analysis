import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_21056_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            Arrays.stream(filesInDirectory)
                    .filter(file -> file.getName().equals("A08_IntegrityFailure.pdf"))
                    .findFirst()
                    .ifPresent(file -> System.out.println("Found integrity failure file: " + file.getAbsolutePath()));
        } else {
            System.out.println("No files found in directory " + directoryPath);
        }
    }
}