import java.io.File;
import java.util.regex.Pattern;
import java.util.Scanner;

public class java_07428_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file pattern (e.g., .txt):");
        String filePattern = scanner.nextLine();

        FileScanner scannerImpl = new FileScanner(directoryPath, filePattern);
        scannerImpl.scanFiles();
    }

}

class FileScanner {

    private final String directoryPath;
    private final String filePattern;

    public java_07428_FileScanner_A03(String directoryPath, String filePattern) {
        this.directoryPath = directoryPath;
        this.filePattern = filePattern;
    }

    public void scanFiles() {
        File file = new File(directoryPath);
        searchFiles(file);
    }

    private void searchFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    searchFiles(f);
                } else if (f.getName().matches(filePattern)) {
                    System.out.println(f.getPath());
                }
            }
        }
    }

}