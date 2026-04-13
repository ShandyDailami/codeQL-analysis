import java.io.File;
import java.io.IOException;

public class java_34970_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Get the current directory
        File currentDir = new File(".");

        // Print the name of all files in the current directory
        System.out.println("Files in current directory:");
        printFiles(currentDir, 0);
    }

    private static void printFiles(File dir, int indent) throws IOException {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If file is a directory, print the directory name and recursively call printFiles
                    System.out.println("  ".repeat(indent) + file.getName() + "/");
                    printFiles(file, indent + 1);
                } else {
                    // If file is a file, print the file name
                    System.out.println("  ".repeat(indent) + file.getName());
                }
            }
        }
    }
}