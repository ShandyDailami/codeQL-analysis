import java.io.File;
import java.util.Scanner;

public class java_26135_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        searchFile(new File(path), fileName);
    }

    public static void searchFile(File directory, String fileName) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    } else {
                        searchFile(file, fileName);
                    }
                }
            }
        } else {
            if (directory.getName().equals(fileName)) {
                System.out.println("File found: " + directory.getAbsolutePath());
            }
        }
    }
}