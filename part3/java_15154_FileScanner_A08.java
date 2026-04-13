import java.io.File;
import java.util.Scanner;

public class java_15154_FileScanner_A08 {
    public static void main(String[] args) {
        System.out.println("Enter directory path:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getPath());
                String[] files = file.list();

                for (String name : files) {
                    File f = new File(file.getPath() + "/" + name);

                    if (f.isFile()) {
                        if (f.getName().endsWith(".java")) {
                            System.out.println("Java file found: " + f.getPath());
                        }
                    } else if (f.isDirectory()) {
                        System.out.println("Directory found: " + f.getPath());
                    }
                }
            } else {
                System.out.println("File found: " + file.getPath());
            }
        } else {
            System.out.println("File or directory not found.");
        }
    }
}