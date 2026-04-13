import java.io.File;
import java.util.Scanner;

public class java_34971_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(dir.getPath() + "/" + file);
                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println("File name: " + fileObj.getName());
                        System.out.println("Absolute path: " + fileObj.getAbsolutePath());
                        System.out.println("Readable: " + fileObj.canRead());
                    }
                }
            } else {
                System.out.println("The directory is empty!");
            }
        } else {
            System.out.println("The provided path is not a valid directory!");
        }
    }
}