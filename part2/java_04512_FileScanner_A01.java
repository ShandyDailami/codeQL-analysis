import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04512_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        readDirectory(new File(dirPath));
    }

    public static void readDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    readDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}