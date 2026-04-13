import java.io.File;
import java.util.Scanner;

public class java_21460_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File dir = new File(dirPath);
        File[] listOfFiles = dir.listFiles((dir2, name) -> name.endsWith(fileExtension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getPath());
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}