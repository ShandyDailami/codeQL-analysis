import java.io.File;
import java.util.Scanner;

public class java_00219_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to filter out: ");
        String fileName = scanner.nextLine();

        String folderPath = "C:\\Users\\username\\Desktop\\"; // Adjust this to the path where your files are located

        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.getName().contains(fileName)) {
                System.out.println("File name contains placeholder, skipping...");
            } else {
                System.out.println("File name: " + file.getName());
            }
        }
        scanner.close();
    }
}