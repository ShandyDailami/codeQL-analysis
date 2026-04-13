import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38439_FileScanner_A08 {

    private File file;

    public java_38439_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // We're assuming that the integrity failure is a result of trying to access a file
                // that contains a hardcoded password.
                if (line.contains("hardcoded_password")) {
                    System.out.println("Integrity failure detected in file: " + this.file.getPath());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + this.file.getPath());
        }
    }

    public static void main(String[] args) {
        SecurityVanillaFileScanner scanner = new SecurityVanillaFileScanner("./target/classes/test.txt");
        scanner.scanFile();
    }
}