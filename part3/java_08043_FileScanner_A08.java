import java.io.File;
import java.util.Scanner;

public class java_08043_FileScanner_A08 {
    public static void main(String[] args) {
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

    private static void listFiles(File directory, int indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < indent; i++) {
                    System.out.print("  ");
                }
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("/" + file.getName());
                    listFiles(file, indent + 1);
                }
            }
        }
    }
}