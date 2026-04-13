import java.io.File;
import java.util.Scanner;

public class java_11237_FileScanner_A07 {

    // Step 1: Define a method to check if a given directory path is accessible.
    public boolean isAccessibleDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        return dir.exists() && dir.canRead();
    }

    // Step 2: Define a method to check if a given file path is accessible.
    public boolean isAccessibleFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.canRead();
    }

    // Step 3: Create a method to start the scanning process.
    public void scan(String directoryPath) {
        if (isAccessibleDirectory(directoryPath)) {
            File[] listOfFiles = (new File(directoryPath + "/*")).listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && isAccessibleFile(listOfFiles[i].getPath())) {
                    System.out.println("File: " + listOfFiles[i].getName() + " is accessible.");
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory: " + listOfFiles[i].getName() + " is accessible.");
                    scan(listOfFiles[i].getPath());
                }
            }
        } else {
            System.out.println("Directory: " + directoryPath + " is not accessible.");
        }
    }

    public static void main(String[] args) {
        AuthFailureDetector detector = new AuthFailureDetector();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        detector.scan(directoryPath);
        scanner.close();
    }
}