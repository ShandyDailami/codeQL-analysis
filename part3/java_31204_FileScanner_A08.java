import java.io.File;
import java.util.Scanner;

public class java_31204_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("It's a directory");
                String[] files = file.list();

                if (files != null) {
                    for (String str : files) {
                        System.out.println(str);
                    }
                } else {
                    System.out.println("No files in directory");
                }
            } else {
                System.out.println("It's not a directory");
            }
        } else {
            System.out.println("The file or directory does not exist");
        }

        scanner.close();
    }
}