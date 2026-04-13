import java.io.File;
import java.util.Scanner;

public class java_08221_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}