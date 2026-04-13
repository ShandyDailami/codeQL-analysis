import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20891_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_directory";
        File directory = new File(directoryPath);

        // Use a FileFilter to only look for .txt files
        File[] txtFiles = directory.listFiles((File dir, String name) -> name.endsWith(".txt"));

        // Check if directory exists and if not, print an error message
        if (txtFiles == null) {
            System.out.println("Directory does not exist or no read permissions are granted.");
            return;
        }

        // Use a FileVisitor to print out the names of the txt files
        new FileVisitor() {
            @Override
            public void visit(File file) {
                if (file.isFile()) {
                    System.out.println("Txt file: " + file.getName());
                }
            }
        }.visit(txtFiles);
    }

    // The FileVisitor interface
    interface FileVisitor {
        void visit(File file);
    }
}