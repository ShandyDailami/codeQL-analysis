import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22701_FileScanner_A07 {

    private static String targetString;

    public java_22701_FileScanner_A07(String targetString) {
        this.targetString = targetString;
    }

    public void startSearch(String directoryPath) {
        File startDirectory = new File(directoryPath);
        findFiles(startDirectory);
    }

    private void findFiles(File directory) {
        File[] foundFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    findFiles(pathname);
                    return true;
                } else if (pathname.getName().contains(targetString)) {
                    printFileInfo(pathname);
                }
                return false;
            }
        });
    }

    private void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the target string:");
        String targetString = scanner.nextLine();
        SecureFileScanner scannerImpl = new SecureFileScanner(targetString);
        scannerImpl.startSearch(directoryPath);
    }
}