import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15285_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory exists: " + directory.getAbsolutePath());

            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();

            File file = new File(directory, fileName);

            if (file.exists() && file.canRead()) {
                try {
                    FileScanner scanner = new FileScanner(file);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Read line: " + line);
                    }

                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            } else {
                System.out.println("File does not exist or cannot be read: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist: " + directory.getAbsolutePath());
        }

        scanner.close();
    }
}