import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14370_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter directory path:");
            String path = scanner.nextLine();
            File dir = new File(path);

            if (dir.isDirectory()) {
                String[] list = dir.list();
                for (String fileName : list) {
                    File file = new File(dir, fileName);
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Not a directory!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}