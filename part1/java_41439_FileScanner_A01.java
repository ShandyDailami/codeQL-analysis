import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41439_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File file = new File(directoryPath + "/" + fileName);

        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        if (file.isFile()) {
            System.out.println("Path is not a directory");
            return;
        }

        File[] hiddenFiles = file.listFiles((dir, name) -> name.startsWith("."));
        if (hiddenFiles == null) {
            System.out.println("Unable to list hidden files");
            return;
        }

        Arrays.stream(hiddenFiles).forEach(hiddenFile -> {
            if (hiddenFile.isFile()) {
                System.out.println("Found hidden file: " + hiddenFile.getName());
            } else {
                System.out.println("Found directory: " + hiddenFile.getName());
            }
        });
    }
}