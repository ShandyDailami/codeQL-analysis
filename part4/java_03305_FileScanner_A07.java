import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03305_FileScanner_A07 {
    private final String directory;

    public java_03305_FileScanner_A07(String directory) {
        this.directory = directory;
    }

    public void scan() {
        File root = new File(directory);
        findFiles(root, "AuthFailure");
    }

    private void findFiles(File root, String keyword) {
        File[] matchingFiles = root.listFiles((dir, name) -> name.endsWith(keyword));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                if (file.isFile()) {
                    printFile(file);
                } else if (file.isDirectory()) {
                    findFiles(file, keyword);
                }
            }
        }
    }

    private void printFile(File file) {
        System.out.println("File: " + file.getPath());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory to scan:");
        String directory = scanner.nextLine();

        SecureFileScanner scannerInstance = new SecureFileScanner(directory);
        scannerInstance.scan();
    }
}