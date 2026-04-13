import java.io.File;
import java.util.Scanner;

public class java_01890_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".txt")) {
                        System.out.println("File: " + fileName);
                    }
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }
    }
}