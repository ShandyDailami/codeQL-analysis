import java.io.File;
import java.util.Scanner;

public class java_34112_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + directoryPath);
                File[] files = file.listFiles();

                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println("File: " + f.getName());
                    } else if (f.isDirectory()) {
                        System.out.println("Directory: " + f.getName());
                    }
                }
            } else {
                System.out.println("File: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }

        scanner.close();
    }
}