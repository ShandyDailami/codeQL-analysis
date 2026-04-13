import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34533_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileToSearch = "A08_IntegrityFailure";
        scanFilesInDirectory(directoryPath, fileToSearch);
    }

    public static void scanFilesInDirectory(String directoryPath, String fileToSearch) {
        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles();

        if (directoryFiles != null) {
            for (File file : directoryFiles) {
                if (file.isFile() && file.getName().contains(fileToSearch)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                       
                            // Add your security-sensitive operations here
                            // For example, verify the integrity of the file
                            if (file.getAbsolutePath().contains("A08_IntegrityFailure")) {
                                System.out.println("Integrity failure detected in file: " + file.getAbsolutePath());
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}