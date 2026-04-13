import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23032_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            FileScanner fileScanner = new FileScanner(directory);
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.next();
                File file = new File(filePath);
                System.out.println("File name: " + file.getName());
            }
            fileScanner.close();
        } else {
            System.out.println("The specified directory does not exist");
        }
    }
}

class FileScanner {
    private java.io.FileScanner fileScanner;

    public java_23032_FileScanner_A01(java.io.File directory) {
        this.fileScanner = new java.io.FileScanner(directory);
    }

    public boolean hasNext() {
        return fileScanner.hasNext();
    }

    public String next() {
        return fileScanner.next();
    }

    public void close() {
        fileScanner.close();
    }
}