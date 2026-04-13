import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11970_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        try {
            File file = new File(filePath);
            scannerFile(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    private static void scannerFile(File file) throws FileNotFoundException {
        if (file.isFile()) {
            if (isFileSecuritySensitive(file)) {
                System.out.println("File is security-sensitive and will not be processed.");
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Processing line: " + line);

                // Remove code below to start with '