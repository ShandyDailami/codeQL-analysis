import java.io.*;

public class java_14775_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        String fileExtension = "exe"; // Replace with your file extension
        String invalidFileExtension = ".bad"; // Replace with your invalid file extension

        File directoryFile = new File(directory);

        File[] executableFiles = directoryFile.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (executableFiles != null) {
            for (File file : executableFiles) {
                if (!file.canExecute()) {
                    System.out.println("Invalid file: " + file.getPath());
                } else {
                    System.out.println("Valid file: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory not found: " + directory);
        }

        // Testing with invalid file extension
        File invalidFile = new File(directory, "non_" + invalidFileExtension);
        if (!invalidFile.exists()) {
            System.out.println("Invalid file: " + invalidFile.getPath());
        } else {
            System.out.println("Valid file: " + invalidFile.getPath());
        }
    }
}