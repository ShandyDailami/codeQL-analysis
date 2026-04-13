import java.io.File;
import java.util.Scanner;

public class java_31724_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                System.out.println("Directory listing:");
                String[] files = dir.list();

                for (String file : files) {
                    File fileObj = new File(dirPath + "/" + file);

                    if (fileObj.isFile()) {
                        System.out.println(fileObj.getName());
                    }
                }
            } else {
                System.out.println("It's not a directory.");
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}