import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36377_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Create FileScanner object
        FileScanner fileScanner = new FileScanner(dirPath);

        // Start scanning files
        fileScanner.start();

        // Scanner for file names
        Scanner fileScannerInput = new Scanner(fileScanner.getInputStream());

        while (fileScannerInput.hasNextLine()) {
            String fileName = fileScannerInput.nextLine();
            System.out.println("Found file: " + fileName);

            // Get file object
            File file = new File(dirPath + "/" + fileName);

            // Security-sensitive operation: Check if file exists
            if (file.exists()) {
                System.out.println("File exists!");
            } else {
                System.out.println("File does not exist!");
            }

            // Security-sensitive operation: Read file content
            if (file.canRead()) {
                Scanner fileScannerContent = new Scanner(file.getContent());
                while (fileScannerContent.hasNextLine()) {
                    System.out.println("Content of file: " + fileScannerContent.nextLine());
                }
            } else {
                System.out.println("Cannot read file!");
            }
        }

        // Close scanner
        fileScannerInput.close();
    }
}

class FileScanner {
    private String directoryPath;

    public java_36377_FileScanner_A03(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public InputStream getInputStream() {
        try {
            return new FileInputStream(new File(directoryPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}