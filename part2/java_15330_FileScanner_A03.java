import java.io.File;
import java.util.Scanner;

public class java_15330_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            System.out.println("Directory exists: " + file.getAbsolutePath());
            listFiles(file, "");
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listFiles(file, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }
}