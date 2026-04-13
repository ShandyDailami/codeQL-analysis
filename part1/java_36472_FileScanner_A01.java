import java.io.File;
import java.util.Scanner;

public class java_36472_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner();
        fileScanner.startScanning();
    }

}

class FileScanner {

    private Scanner scanner;

    FileScanner() {
        this.scanner = new Scanner(System.in);
    }

    void startScanning() {
        System.out.println("Enter directory path:");
        String directoryPath = this.scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory path or no read permissions for the directory.");
        }
    }
}