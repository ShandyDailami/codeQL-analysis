import java.io.File;
import java.util.Scanner;

public class java_28700_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("It's a directory:");
                File[] list = file.listFiles();
                if (list != null) {
                    for (File f : list) {
                        if (f.isFile()) {
                            System.out.println(f.getName());
                        } else {
                            System.out.println("It's a directory: " + f.getName());
                        }
                    }
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