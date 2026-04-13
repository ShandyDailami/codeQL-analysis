import java.io.File;
import java.util.Scanner;

public class java_00782_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            File[] listFiles = file.listFiles();

            for (File f : listFiles) {
                if (!f.isHidden() && (f.isFile() || (f.isDirectory() && f.listFiles().length == 0))) {
                    System.out.println("File found: " + f.getPath());
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}