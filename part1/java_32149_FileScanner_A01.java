import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32149_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        try {
            scanFilesInDirectory(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Invalid directory path!");
        } finally {
            scanner.close();
        }
    }

    private static void scanFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Here we are assuming that the file is text file.
                    // For real world use case, you may want to use a more secure method
                    // to check if a file is executable or not.
                    if (file.getName().endsWith(".txt")) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Here we are assuming that all content in the file is safe.
                            // In a real world use case, you would want to check the content
                            // for any potentially harmful content.
                            System.out.println(line);
                        }
                        fileScanner.close();
                    }
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }
}