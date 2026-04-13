import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_08473_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the file extension to search:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = (dir, name) -> name.endsWith(fileExtension);

        File[] listOfFiles = directory.listFiles(filter);

        if (listOfFiles == null) {
            System.out.println("No files found with the specified extension.");
            return;
        }

        System.out.println("Files with the specified extension: " + Arrays.toString(listOfFiles));
    }
}