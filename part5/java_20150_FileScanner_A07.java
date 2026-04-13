import java.io.File;
import java.util.Scanner;

public class java_20150_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("Reading content of file: " + file.getName());

                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty or does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}