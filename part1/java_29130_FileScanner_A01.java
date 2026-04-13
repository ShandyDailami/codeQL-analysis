import java.io.File;
import java.util.Scanner;

public class java_29130_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            System.out.println("Directory listing:");
            String[] fileList = dir.list();

            for (String fileName : fileList) {
                File file = new File(dirPath + "/" + fileName);

                if (file.isFile()) {
                    System.out.println(fileName);
                }
            }
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }
}