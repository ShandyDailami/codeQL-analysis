import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21022_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith(".") && new File(dir, name).setWritable(true));

            if (hiddenFiles != null) {
                for (File hiddenFile : hiddenFiles) {
                    try {
                        Scanner fileScanner = new Scanner(hiddenFile);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Process line as required.
                            System.out.println("Processed line: " + line);
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No hidden files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }

        scanner.close();
    }
}