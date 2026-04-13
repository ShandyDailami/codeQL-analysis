import java.io.*;

public class java_34581_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Windows";  // Replace with your directory path
        String searchTerm = "notepad.exe";  // Replace with your search term

        File dir = new File(directoryPath);
        File[] listOfFiles = dir.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().equals(searchTerm)) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                searchInDirectory(file, searchTerm);
            }
        }
    }

    private static void searchInDirectory(File directory, String searchTerm) {
        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().equals(searchTerm)) {
                System.out.println("File found in subdirectory: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                searchInDirectory(file, searchTerm);
            }
        }
    }
}