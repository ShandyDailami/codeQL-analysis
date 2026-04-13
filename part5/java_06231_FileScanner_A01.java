import java.io.File;
import java.util.Scanner;

public class java_06231_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            for (String file : files) {
                File fileObj = new File(dirPath + "/" + file);
                if (fileObj.exists() && !fileObj.isDirectory() && (fileObj.length() > 5000000)) { //5MB limit
                    System.out.println("File name: " + fileObj.getName());
                    System.out.println("File size: " + fileObj.length() + " bytes");
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}