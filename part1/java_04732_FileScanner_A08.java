import java.io.File;
import java.util.Scanner;

public class java_04732_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                String[] files = file.list();
                for (String filename : files) {
                    File fileData = new File(file.getAbsolutePath() + "/" + filename);
                    if (fileData.isFile() && fileData.canRead()) {
                        System.out.println("File: " + fileData.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Not a directory: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("The path does not exist: " + path);
        }
    }
}