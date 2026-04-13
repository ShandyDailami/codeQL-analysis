import java.io.File;
import java.util.Scanner;

public class java_00405_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getAbsolutePath());
                File[] list = file.listFiles();
                if (list != null) {
                    for (File f : list) {
                        if (f.isFile()) {
                            if (f.getName().endsWith(".txt")) {
                                System.out.println("File found: " + f.getAbsolutePath());
                            }
                        } else if (f.isDirectory()) {
                            System.out.println("Directory found: " + f.getAbsolutePath());
                        }
                    }
                }
            } else if (file.isFile()) {
                if (file.getName().endsWith(".txt")) {
                    System.out.println("File found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found: " + path);
        }
    }
}