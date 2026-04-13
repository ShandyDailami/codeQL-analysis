import java.io.File;
import java.util.Scanner;

public class java_32771_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);
        if (dir.exists()) {
            File[] listFiles = dir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File name: " + file.getName());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}