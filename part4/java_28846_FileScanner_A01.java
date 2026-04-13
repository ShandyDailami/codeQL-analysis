import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28846_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            for (String fileName : files) {
                File file = new File(directoryPath + "/" + fileName);

                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                } else {
                    System.out.println("Not a file or readable: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}