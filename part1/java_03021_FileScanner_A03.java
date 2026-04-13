import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class java_03021_FileScanner_A03 {
    private static final Logger LOGGER = Logger.getLogger(SecureFileScanner.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    // Removing file extension using regular expression
                    if (fileName.matches(".*\\.(txt|pdf|docx|xlsx)$")) {
                        LOGGER.info("File name: " + fileName);
                    }
                }
            }
        }

        scanner.close();
    }
}