import java.io.File;
import java.util.Scanner;

public class java_39880_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.isDirectory()) {
            String[] list = dir.list();

            if (list != null) {
                for (String fileName : list) {
                    File file = new File(dir, fileName);

                    if (file.isFile() && !file.getName().startsWith(".")) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }
}