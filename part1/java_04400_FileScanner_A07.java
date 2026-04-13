import java.io.File;
import java.util.Scanner;

public class java_04400_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.next();
        System.out.println("Enter the file extension:");
        String extension = scanner.next();

        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}