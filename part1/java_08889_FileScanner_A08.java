import java.io.File;
import java.util.Scanner;

public class java_08889_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        // Checking if the file is not empty and it's a text file
                        if (file.length() > 0 && file.getName().endsWith(".txt")) {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Here, we are assuming that the integrity failure is
                                // when we encounter a word that is not a valid integer or
                                // when we encounter a line that contains more than two words.
                                if (line.split(" ").length > 2 || !line.matches("\\d+")) {
                                    System.out.println("IntegrityFailure detected in: " + file.getPath());
                                }
                            }
                            fileScanner.close();
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while processing the file: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is empty");
        }
        scanner.close();
    }
}