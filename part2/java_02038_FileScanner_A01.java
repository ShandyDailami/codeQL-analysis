import java.io.File;
import java.util.Scanner;

public class java_02038_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            for (String file : files) {
                File fileEntry = new File(directory, file);
                if (fileEntry.isFile()) {
                    System.out.println(fileEntry.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Not a directory.");
        }
    }
}