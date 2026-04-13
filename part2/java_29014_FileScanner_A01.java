import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29014_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            System.out.println("File: " + file.getName());
                            System.out.println("Size: " + file.length() + " bytes");

                            // read file content
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println("Content: " + line);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getPath());
                        }
                    }
                }
            } else {
                System.out.println("No files in directory: " + directory.getPath());
            }
        } else {
            System.out.println("Not a directory: " + directory.getPath());
        }
    }
}