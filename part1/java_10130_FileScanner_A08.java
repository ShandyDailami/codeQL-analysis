import java.io.File;
import java.util.Scanner;

public class java_10130_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = input.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("File name: " + file.getName());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        input.close();
    }
}