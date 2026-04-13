import java.io.File;
import java.util.Scanner;

public class java_42012_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to list files in subdirectories? (y/n)");
        char response = scanner.next().charAt(0);

        File file = new File(".");

        if (response == 'y') {
            file = new File(".");
        } else {
            file = new File(".");
        }

        listFiles(file, ".txt");
    }

    private static void listFiles(File file, String extension) {
        File[] files = file.listFiles((dir, name) -> name.endsWith(extension));

        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                listFiles(f, extension);
            }
        }
    }
}