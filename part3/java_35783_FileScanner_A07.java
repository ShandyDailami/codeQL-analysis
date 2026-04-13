import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35783_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = "txt"; // replace with your file extension
        String searchTerm = "AuthFailure"; // replace with your search term

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(searchTerm)) {
                                System.out.println("File: " + file.getPath() + " contains the search term: " + searchTerm);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No files found with the extension: " + fileExtension);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}