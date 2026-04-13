import java.io.File;
import java.util.Scanner;

public class java_24086_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listOfFiles = file.listFiles();
                if (listOfFiles != null) {
                    for (File f : listOfFiles) {
                        if (f.isFile() && f.getName().endsWith(".txt")) {
                            System.out.println("File found: " + f.getName());
                        } else if (f.isDirectory()) {
                            System.out.println("Directory found: " + f.getName());
                            listFiles(f);
                        }
                    }
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("File or directory not found");
        }

        scanner.close();
    }

    private static void listFiles(File file) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println("File found: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("Directory found: " + f.getName());
                    listFiles(f);
                }
            }
        }
    }
}