import java.io.File;
import java.util.Scanner;

public class java_04236_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Listing files in " + dirPath);
            String[] files = dir.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(dirPath + "/" + file);
                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println(fileObj.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}