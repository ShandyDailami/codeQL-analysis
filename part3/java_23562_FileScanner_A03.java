import java.io.File;
import java.util.Scanner;

public class java_23562_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("File: " + file.getName());
                }
            } else {
                System.out.println("No .txt files in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}