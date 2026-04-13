import java.io.File;
import java.util.Scanner;

public class java_32308_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter directory path: ");
            String directoryPath = scanner.nextLine();

            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                   
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}