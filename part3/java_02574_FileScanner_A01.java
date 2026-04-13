import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02574_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        listFiles(directory, 0);
    }

    private static void listFiles(File directory, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, indent + 1);
            } else {
                for (int i = 0; i < indent; i++) {
                    System.out.print("  ");
                }
                System.out.println(file.getName());
            }
        }
    }
}