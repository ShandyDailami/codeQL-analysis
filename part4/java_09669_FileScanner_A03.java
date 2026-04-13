import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_09669_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(indent + "- " + file.getName());
            }
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                listFiles(file, indent + "  ");
            }
        }
    }
}