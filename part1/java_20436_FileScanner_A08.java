import java.io.File;
import java.util.Scanner;

public class java_20436_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();

        File file = new File(directory);

        if (file.exists()) {
            listFiles(file, directory);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    public static void listFiles(File file, String path) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath().substring(path.length() + 1));
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getAbsolutePath());
                    listFiles(f, path);
                }
            }
        }
    }
}