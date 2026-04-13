import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29375_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, 0);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }

        System.out.println(directory.getName());

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, level + 1);
                } else {
                    for (int i = 0; i < level + 1; i++) {
                        System.out.print("--");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}