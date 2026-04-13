import java.io.File;
import java.util.Scanner;

public class java_35377_FileScanner_A08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files from directory: " + directoryPath);

            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("-------------------------------");
                        System.out.println("Reading content from: " + file.getAbsolutePath());

                        Scanner fileScanner = new Scanner(file);

                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }

                        fileScanner.close();
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path!");
        }

        scanner.close();
    }
}