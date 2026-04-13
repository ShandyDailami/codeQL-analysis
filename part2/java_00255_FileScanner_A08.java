import java.io.File;
import java.util.Scanner;

public class java_00255_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        Scanner scanner = new Scanner(System.in);

        if (dir.isDirectory()) {
            System.out.println("Listing files in " + dir + ":");
            listFiles(dir, scanner);
        } else {
            System.out.println("Not a directory.");
        }

        scanner.close();
    }

    private static void listFiles(File dir, Scanner scanner) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory()) {
                    listFiles(file, scanner);
                }
            }
        }
    }
}