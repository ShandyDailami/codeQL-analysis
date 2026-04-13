import java.io.File;
import java.util.Scanner;

public class java_02908_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileName = "your_file_name.txt"; // replace with your file name

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Directory does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        // Close the scanner
        ((Scanner) context).close();
    }
}