import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41755_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);

        if (dir.isDirectory()) {
            String[] files = dir.list();

            for (String file : files) {
                File fileObj = new File(dir.getPath() + "/" + file);

                if (fileObj.isFile()) {
                    System.out.println("File: " + fileObj.getName());
                } else if (fileObj.isDirectory()) {
                    System.out.println("Directory: " + fileObj.getName());
                }
            }
        } else {
            System.out.println("Not a directory!");
        }
    }
}