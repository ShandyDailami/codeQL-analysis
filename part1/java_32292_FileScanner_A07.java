import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_32292_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in the directory.");
            return;
        }

        for (File file : files) {
            if (!file.canRead()) {
                System.out.println("File " + file.getName() + " is not readable.");
            } else {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains("AuthFailure")) {
                            System.out.println("File " + file.getName() + " contains AuthFailure.");
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}