import java.io.File;
import java.util.Scanner;

public class java_36911_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Scanning files in directory: " + file.getAbsolutePath());
                File[] listOfFiles = file.listFiles();
                for (File f : listOfFiles) {
                    if (f.isFile()) {
                        String absolutePath = f.getAbsolutePath();
                        String relativePath = absolutePath.replace(file.getAbsolutePath(), "");
                        System.out.println("File Name: " + f.getName());
                        System.out.println("Relative Path: " + relativePath);
                    }
                }
            } else {
                System.out.println(file.getAbsolutePath() + " is not a directory");
            }
        } else {
            System.out.println("The given path does not exist");
        }
    }
}