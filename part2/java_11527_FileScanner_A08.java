import java.io.*;

public class java_11527_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "C:\\path\\to\\directory"; // Replace with your directory path
        String extension = "txt"; // Replace with your desired file extension

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println("File Name: " + file.getName());
                System.out.println("File Path: " + file.getPath());
                System.out.println();
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }
    }
}