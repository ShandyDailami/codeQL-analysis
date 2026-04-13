import java.io.File;
import java.util.Scanner;

public class java_30487_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter word to search in files:");
        String searchWord = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.canRead()) {
                    if (file.getName().contains(searchWord)) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}