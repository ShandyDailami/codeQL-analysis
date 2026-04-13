import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27455_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for reading the input file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Get the file size
        long totalSize = 0;
        try (Scanner fileListScanner = new Scanner(new java.io.File("."));) {
            while (fileListScanner.hasNext()) {
                String fileName = fileListScanner.next();
                File file = new File(dirPath + "/" + fileName);
                if (file.exists()) {
                    totalSize += file.length();
                }
            }
        }

        // Print the size
        System.out.println("Total size of files in the directory: " + totalSize + " bytes");
    }
}