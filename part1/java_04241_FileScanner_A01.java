import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04241_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your actual directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner(directory, ".dat");
            Scanner fileScannerScanner = fileScanner.scan();

            while (fileScannerScanner.hasNext()) {
                String filePath = fileScannerScanner.next();
                try {
                    File file = new File(filePath);
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        // Here you can add code to access or modify files in the directory.
                        // If the file is encrypted, you'll need to decrypt it before access.
                        // This is a very simplified example, actual implementation may be much more complex.
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File " + filePath + " not found");
                }
            }
            fileScannerScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Directory not found");
        }
    }
}