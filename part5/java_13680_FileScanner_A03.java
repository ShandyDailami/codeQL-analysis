import java.io.File;
import java.util.Scanner;

public class java_13680_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        FileScanner(new File(dirPath));
    }

    public static void FileScanner(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        FileScanner(file);
                    } else {
                        System.out.println(file.getName());
                    }
                }
            }
        }
    }
}