import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22317_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory contents:");
            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid directory or it does not exist.");
        }
    }
}