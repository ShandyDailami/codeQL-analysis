import java.io.File;
import java.util.Scanner;

public class java_14673_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("The given path is a directory: " + file.getAbsolutePath());
                System.out.println("Files in the directory:");

                String[] files = file.list();

                for (String fileName : files) {
                    File temp = new File(file.getAbsolutePath() + "/" + fileName);

                    if (temp.isFile() && temp.canRead()) {
                        System.out.println("File Name: " + temp.getName());
                        System.out.println("Absolute Path: " + temp.getAbsolutePath());
                        System.out.println("Readable: " + temp.canRead());
                        System.out.println("Writable: " + temp.canWrite());
                        System.out.println("Executable: " + temp.canExecute());
                        System.out.println("-------------------------------");
                    }
                }
            } else {
                System.out.println("The given path is not a directory");
            }
        } else {
            System.out.println("The given path does not exist");
        }

        scanner.close();
    }
}