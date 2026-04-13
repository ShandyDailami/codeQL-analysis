import java.io.File;
import java.util.Scanner;

public class java_05813_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, 0);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void listFiles(File directory, int indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // indent for subdirectories
                    listFiles(file, indent + 1);
                } else {
                    printIndent(indent);
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
    }
}