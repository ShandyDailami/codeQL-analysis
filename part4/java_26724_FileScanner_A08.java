import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_26724_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file pattern (e.g., *.txt): ");
        String filePattern = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory!");
            System.exit(1);
        }

        System.out.println("Searching for files in directory: " + directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(filePattern));
        if (matchingFiles == null) {
            System.out.println("No files found that match the pattern!");
            System.exit(1);
        }

        Arrays.stream(matchingFiles)
                .filter(File::isFile)
                .forEach(file -> System.out.println("Found file: " + file.getAbsolutePath()));
    }
}