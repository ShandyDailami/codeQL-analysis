import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class java_32054_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File file = new File(dirPath);

        if (file.exists()) {
            scanDirectory(file, dirPath);
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void scanDirectory(File dir, String path) {
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    scanDirectory(file, path + "/" + file.getName());
                } else {
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        long length = file.length();
                        System.out.println(path + "/" + file.getName() + " size: " + length);
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}