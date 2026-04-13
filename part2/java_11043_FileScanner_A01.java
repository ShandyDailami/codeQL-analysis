import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11043_FileScanner_A01 {
    private String directoryPath;

    public java_11043_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Cannot read directory!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in directory!");
            return;
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.canRead())
                .forEach(this::printFileDetails);
    }

    private void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getPath());
        System.out.println("File Size: " + file.length() + " bytes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        SecureFileScanner scannerInstance = new SecureFileScanner(directoryPath);
        scannerInstance.scanDirectory();
    }
}