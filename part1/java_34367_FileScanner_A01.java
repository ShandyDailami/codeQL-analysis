import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_34367_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory does not exist or is not a directory");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, indent + "  ");
            } else {
                System.out.println(indent + file.getName());
            }
        }
    }
}