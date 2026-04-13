import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00778_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        printFiles(directory, 0);
    }

    private static void printFiles(File directory, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file, level + 1);
                } else {
                    System.out.println(getFileDetails(file));
                }
            }
        }
    }

    private static String getFileDetails(File file) {
        StringBuilder details = new StringBuilder();
        details.append(file.getName());
        details.append(" ");
        details.append(file.length());
        details.append(" bytes");
        return details.toString();
    }
}