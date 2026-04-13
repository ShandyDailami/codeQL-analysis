import java.io.File;
import java.util.Scanner;

public class java_11321_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file extension to exclude:");
        String fileExt = scanner.nextLine();

        File directory = new File(dirPath);

        File[] listOfFiles = directory.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && !listOfFiles[i].getName().endsWith(fileExt)) {
                System.out.println(listOfFiles[i].getName());
            }
        }
    }
}