import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12122_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.getName().equals("A08_IntegrityFailure")) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        }
    }
}