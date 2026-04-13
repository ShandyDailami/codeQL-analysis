import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38591_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        String fileName = "A07_AuthFailure.txt"; // Replace with the specific file you're searching for

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getPath());
                    }
                }
            }
        } else {
            System.out.println("No files found in directory: " + directoryPath);
        }
    }
}