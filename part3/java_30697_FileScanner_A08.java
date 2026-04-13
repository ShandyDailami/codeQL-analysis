import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30697_FileScanner_A08 {

    // Integrity failure class to check the file integrity
    private class FileIntegrityFailure {
        private String filename;

        public java_30697_FileScanner_A08(String filename) {
            this.filename = filename;
        }

        public void checkFileIntegrity() {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File " + filename + " not found.");
            } else {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.matches(".*[`~^@$#+=].*")) {
                            System.out.println("Integrity failure detected in file: " + filename);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new FileScanner().start();
    }

    private void start() {
        FileIntegrityFailure integrityFailure = new FileIntegrityFailure("path_to_file");
        integrityFailure.checkFileIntegrity();
    }
}