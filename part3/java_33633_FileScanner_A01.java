import java.io.File;
import java.util.Scanner;

public class java_33633_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the exception file names (comma separated):");
        String[] exceptions = scanner.nextLine().split(",");

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            String[] files = dir.list();
            if (files != null) {
                for (String file : files) {
                    if (!isException(file, exceptions)) {
                        System.out.println(file);
                    }
                }
            }
        } else {
            System.out.println("Not a directory!");
        }
    }

    private static boolean isException(String file, String[] exceptions) {
        for (String exception : exceptions) {
            if (file.equals(exception)) {
                return true;
            }
        }
        return false;
    }
}