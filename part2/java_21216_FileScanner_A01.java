import java.io.File;
import java.util.Scanner;

public class java_21216_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // This is a file, not a directory
                    if (file.getName().endsWith(".txt")) {
                        System.out.println(indent + file.getName());
                    }
                } else if (file.isDirectory()) {
                    // This is a directory, recursively list its content
                    listFiles(file, indent + "  ");
                }
            }
        }
    }
}