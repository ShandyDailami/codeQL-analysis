import java.io.File;
import java.util.Scanner;

public class java_40714_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory contents:");
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    }
                }
            } else {
                System.out.println("The provided path does not exist or is not a directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }

        scanner.close();
    }
}