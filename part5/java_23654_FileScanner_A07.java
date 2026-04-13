import java.io.File;
import java.util.Scanner;

public class java_23654_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory found: " + file.getAbsolutePath());
                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            System.out.println("File: " + f.getAbsolutePath() + ", Size: " + f.length() + " bytes");
                        }
                    }
                }
            } else {
                System.out.println("File found: " + file.getAbsolutePath());
                System.out.println("Size: " + file.length() + " bytes");
            }
        } else {
            System.out.println("Directory not found!");
        }
    }
}