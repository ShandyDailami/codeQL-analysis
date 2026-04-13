import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_31501_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        listFiles(directory, 0);
    }

    private static void listFiles(File directory, int indent) {
        if (directory.listFiles() == null) {
            return;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            for (int i = 0; i < indent; i++) {
                System.out.print("  ");
            }

            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("  " + file.getName() + "/");
                listFiles(file, indent + 1);
            }
        }
    }
}