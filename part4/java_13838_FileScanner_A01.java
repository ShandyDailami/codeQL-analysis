import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_13838_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dirPath = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(dirPath);
        fileScanner.startScanning();
    }

    static class FileScanner {
        private String directoryPath;

        public java_13838_FileScanner_A01(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public void startScanning() {
            File directory = new File(directoryPath);
            findFile(directory);
        }

        private void findFile(File file) {
            if (file.isFile() && file.getName().equals("A01_BrokenAccessControl.txt")) {
                System.out.println("File found!");
            } else {
                File[] files = file.listFiles();
                if (files != null) {
                    Arrays.stream(files).forEach(this::findFile);
                }
            }
        }
    }
}