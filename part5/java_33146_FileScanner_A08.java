import java.io.File;
import java.util.Scanner;

public class java_33146_FileScanner_A08 {

    private static File file;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        file = new File(filePath);

        if (file.exists() && file.isFile()) {
            secureFileScan(file);
        } else {
            System.out.println("File does not exist or is not a file.");
        }
    }

    private static void secureFileScan(File file) {
        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isDirectory()) {
                    secureFileScan(f);
                } else {
                    if (isFileSecure(f)) {
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static boolean isFileSecure(File file) {
        if (file.canRead() && !file.canWrite()) {
            System.out.println("Reading security issue: " + file.getAbsolutePath());
            return false;
        }

        if (!file.canRead() && file.canWrite()) {
            System.out.println("Writing security issue: " + file.getAbsolutePath());
            return false;
        }

        if (!file.canRead() && !file.canWrite()) {
            System.out.println("Reading and writing security issues: " + file.getAbsolutePath());
            return false;
        }

        return true;
    }
}