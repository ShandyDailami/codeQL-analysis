import java.io.File;
import java.util.Scanner;

public class java_35393_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile()) {
                        if (list[i].getName().endsWith(".txt")) {
                            System.out.println("File name: " + list[i].getName());
                            System.out.println("Absolute path: " + list[i].getAbsolutePath());
                            System.out.println("----------------------");
                        }
                    } else if (list[i].isDirectory()) {
                        System.out.println("Directory name: " + list[i].getName());
                        System.out.println("Absolute path: " + list[i].getAbsolutePath());
                        System.out.println("----------------------");
                    }
                }
            } else {
                System.out.println("The given path is not a directory");
            }
        } else {
            System.out.println("The given path does not exist");
        }
    }
}