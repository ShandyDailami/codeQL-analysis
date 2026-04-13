import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38304_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner fileScanner = null;
                        try {
                            fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Here we add security-sensitive operations related to A01_BrokenAccessControl.
                                // For example, check if the line contains specific credentials or usernames.
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}