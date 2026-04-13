import java.io.File;
import java.util.Scanner;

public class java_22003_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File directory = new File(dirPath);

        File[] result = directory.listFiles((dir, name) -> name.equals(fileName));

        if (result == null || result.length == 0) {
            System.out.println("No file found with name: " + fileName);
        } else {
            for (File file : result) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getName());
                }
            }
        }
    }
}