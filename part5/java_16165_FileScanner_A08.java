import java.io.File;
import java.util.Scanner;

public class java_16165_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        FileScanner fileScanner = new FileScanner();
        fileScanner.startScanning(new File(dirPath));
    }
}

class FileScanner {
    public void startScanning(File file) {
        if (file.exists()) {
            printDirectoryContent(file, "");
        } else {
            System.out.println("The specified file or directory does not exist.");
        }
    }

    private void printDirectoryContent(File file, String indentation) {
        for (int i = 0; i < indentation.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(file.getName());

        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            for (File subFile : subFiles) {
                printDirectoryContent(subFile, indentation + "  ");
            }
        }
    }
}