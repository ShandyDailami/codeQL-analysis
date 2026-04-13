import java.io.File;
import java.util.Scanner;

public class java_38247_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.endsWith(".txt")) {
                        System.out.println("File Name: " + name);
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        }

        scanner.close();
    }
}