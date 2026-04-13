import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_36445_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(fileExtension));

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                System.out.println("Deleting file: " + file.getName());
                file.delete();
            });
        } else {
            System.out.println("No files with extension: " + fileExtension + " found in directory: " + dirPath);
        }
    }
}