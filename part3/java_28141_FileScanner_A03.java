import java.io.File;
import java.util.Scanner;

public class java_28141_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                int fileCount = files.length;
                long totalSize = 0;
                for (File f : files) {
                    if (f.isFile() && (f.length() > 0)) {
                        totalSize += f.length();
                    }
                }
                System.out.println("Number of files: " + fileCount);
                System.out.println("Total size of files: " + totalSize + " bytes");
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}