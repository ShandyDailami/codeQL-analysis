import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_20499_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles == null) {
            System.out.println("No .txt files found in directory.");
            return;
        }

        Arrays.stream(txtFiles).forEach(file -> {
            if (file.isFile()) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        });

        scanner.close();
    }
}