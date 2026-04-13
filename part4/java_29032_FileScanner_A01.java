import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_29032_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            List<File> files = new ArrayList<>(directory.listFiles());
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    File[] subFiles = file.listFiles();
                    if (subFiles != null) {
                        for (File subFile : subFiles) {
                            System.out.println("  Directory: " + subFile.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}