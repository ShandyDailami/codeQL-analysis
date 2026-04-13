import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_17508_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Scanning directory: " + dirPath);

            // Using a recursive FileScanner
            FileScanner fileScanner = new FileScanner(dir);
            fileScanner.scanFiles(file -> {
                if (file.isFile() && isFileSafeToRead(file)) {
                    System.out.println("Found safe file: " + file.getAbsolutePath());
                }
            });

        } else {
            System.out.println("Invalid directory or it doesn't exist.");
        }
    }

    // Here we'll use a simple String-based approach for this example.
    // In a real application, you'd use a more sophisticated approach like using
    // a database to store known safe files and then scanning the database for matches.
    private static boolean isFileSafeToRead(File file) {
        return file.getName().endsWith(".java");
    }

    private static class FileScanner {
        private File directory;

        public java_17508_FileScanner_A03(File directory) {
            this.directory = directory;
        }

        public void scanFiles(FileScanner.FileVisitor fileVisitor) {
            File[] files = directory.listFiles();
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    fileVisitor.visit(file);
                } else if (file.isDirectory()) {
                    scanFiles(new FileScanner(file));
                }
            });
        }

        public interface FileVisitor {
            void visit(File file);
        }
    }
}