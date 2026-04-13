import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_20705_FileScanner_A01 {

    private static class FileAccessChecker {

        private final File file;

        public java_20705_FileScanner_A01(File file) {
            this.file = file;
        }

        public boolean check() {
            return file.canRead();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            FileAccessChecker checker = new FileAccessChecker(directory);
            if (checker.check()) {
                scanFiles(directory);
            } else {
                System.out.println("The program is not allowed to access the directory due to security reasons.");
            }
        } else {
            System.out.println("The provided directory does not exist.");
        }

        scanner.close();
    }

    private static void scanFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            Arrays.stream(files)
                    .filter(f -> f.isFile())
                    .forEach(f -> new FileAccessChecker(f).check());
        }
    }
}