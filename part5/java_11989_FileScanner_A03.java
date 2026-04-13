import java.io.File;
import java.util.Scanner;

public class java_11989_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root directory:");
        String rootDirectory = scanner.nextLine();

        File root = new File(rootDirectory);

        if (root.exists()) {
            printFilesAndDirectories(root, "");
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void printFilesAndDirectories(File file, String indentation) {
        for (int i = 0; i < indentation.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFilesAndDirectories(f, indentation + " ");
                }
            }
        }
    }
}