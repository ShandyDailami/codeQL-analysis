import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28832_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(fileExtension);
            }
        };

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles(filter);

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Directory not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}