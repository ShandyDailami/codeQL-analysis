import java.io.File;
import java.util.Scanner;

public class java_23342_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String extension = scanner.nextLine();
        System.out.print("Enter the file name: ");
        String name = scanner.nextLine();

        File root = new File(path);
        searchFile(root, extension, name);
        scanner.close();
    }

    public static void searchFile(File root, String extension, String name) {
        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                if (file.getName().endsWith(extension)) {
                    if (file.getName().contains(name)) {
                        System.out.println("File found: " + file.getPath());
                    }
                }
                searchFile(file, extension, name);
            }
        }
    }
}