import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04045_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                fileList(file);
            } else {
                System.out.println("Error: " + file.getPath() + " is not a directory.");
            }
        } else {
            System.out.println("Error: " + path + " does not exist.");
        }
    }

    public static void fileList(File file) {
        if (file.listFiles() != null) {
            for (File f : file.listFiles()) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                } else {
                    fileList(f);
                }
            }
        }
    }
}