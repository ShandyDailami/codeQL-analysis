import java.io.File;
import java.util.Scanner;

public class java_25076_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();

            for (String fileName : files) {
                File file = new File(dirPath + "/" + fileName);

                if (file.exists() && file.isFile()) {
                    System.out.println(fileName);
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}