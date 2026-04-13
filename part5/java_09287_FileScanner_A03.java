import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09287_FileScanner_A03 {
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
                        if (file.getName().endsWith(".txt")) {
                            try {
                                Scanner fileScanner = new Scanner(file);

                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();

                                    // This is a security-sensitive operation related to A03_Injection
                                    // It's a simple example of code to be removed
                                    System.out.println(line);
                                }

                                fileScanner.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}