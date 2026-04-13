import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_03065_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory or no such directory exists.");
            return;
        }

        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        if (files == null) {
            System.out.println("No files in the directory.");
            return;
        }

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}