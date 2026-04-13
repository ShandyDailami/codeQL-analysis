import java.io.File;
import java.util.Scanner;

public class java_09549_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        FileScanner scannerImpl = new FileScanner(dirPath);
        File[] files = scannerImpl.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }

}

class FileScanner {

    private String directoryPath;

    public java_09549_FileScanner_A03(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public File[] listFiles() {
        File dir = new File(directoryPath);
        return dir.listFiles();
    }

}