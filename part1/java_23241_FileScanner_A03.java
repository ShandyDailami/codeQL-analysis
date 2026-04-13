import java.io.File;
import java.util.Scanner;

public class java_23241_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            String[] fileList = dir.list();

            if (fileList != null) {
                for (String fileName : fileList) {
                    File file = new File(dirPath + "/" + fileName);
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}