import java.io.File;
import java.util.Scanner;

public class java_05007_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");

                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                System.out.println("File content: " + fileScanner.nextLine());
                            }
                        }

                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("Invalid directory or directory does not exist.");
        }

        scanner.close();
    }
}