import java.io.File;
import java.util.Scanner;

public class java_32501_FileScanner_A03 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory you want to scan:");
        String dir = scanner.nextLine();

        if (dir.equals(".")) {
            dir = currentDir;
        }

        File file = new File(dir);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile() && f.canRead()) {
                            System.out.println("Reading file: " + f.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("Not a directory!");
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}