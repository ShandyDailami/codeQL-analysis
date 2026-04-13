import java.io.File;
import java.util.Scanner;

public class java_26087_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path!");
            return;
        }

        System.out.println("Listing all files and directories in " + dirPath);
        listFiles(dir, 0);
    }

    private static void listFiles(File dir, int indent) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, indent + 2);
            } else {
                printIndent(indent);
                System.out.println(file.getName());
            }
        }
    }

    private static void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("--");
        }
    }
}