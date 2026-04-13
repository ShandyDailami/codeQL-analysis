import java.io.File;
import java.util.Scanner;

public class java_28255_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of file or directory:");
        String fileName = scanner.next();

        searchFile(directory, fileName);
    }

    private static void searchFile(File directory, String fileName) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.getName().equals(fileName)) {
                    if (file.isFile()) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        searchFile(file, fileName);
                    }
                }
            }
        }
    }
}