import java.io.File;
import java.util.Scanner;

public class java_04864_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            System.out.println("The path " + file.getAbsolutePath() + " is a directory.");
            System.out.println("Enter the file name to search:");
            String fileName = scanner.nextLine();
            File targetFile = new File(file, fileName);

            if (targetFile.exists()) {
                System.out.println("File " + targetFile.getAbsolutePath() + " exists.");
            } else {
                System.out.println("File " + targetFile.getAbsolutePath() + " does not exist.");
            }
        } else {
            System.out.println("The path " + file.getAbsolutePath() + " does not exist or is not a directory.");
        }

        scanner.close();
    }
}