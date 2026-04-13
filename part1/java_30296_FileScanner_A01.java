import java.io.File;
import java.util.Scanner;

public class java_30296_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println("Line in the file: " + line);
                           /*} End of snippet, should not be printed */
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error processing file: " + fileName);
                        }
                    }
                }
            }
        }

        scanner.close();
    }
}