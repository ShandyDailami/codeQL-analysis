import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31707_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            System.out.println("Scanning directory: " + directoryPath);

            String[] fileList = directory.list();

            if (fileList != null) {
                for (String fileName : fileList) {
                    File file = new File(directoryPath + "/" + fileName);

                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                System.out.println("--- File: " + file.getName() + " ---");
                                System.out.println(scanner.nextLine());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println("Not a directory: " + directoryPath);
        }
    }
}