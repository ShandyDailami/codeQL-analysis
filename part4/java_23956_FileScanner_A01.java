import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23956_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] directoryContents = directory.list();

            for (String fileName : directoryContents) {
                File file = new File(directoryPath + "/" + fileName);

                if (file.isFile()) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Error: " + directoryPath + " is not a directory.");
        }
    }
}