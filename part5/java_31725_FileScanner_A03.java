import java.io.File;
import java.util.Scanner;

public class java_31725_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String s : list) {
                File f = new File(file, s);
                if (f.isFile() && f.canRead()) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Not a directory");
        }
    }
}