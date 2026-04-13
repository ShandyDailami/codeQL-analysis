import java.io.File;
import java.util.Scanner;

public class java_03159_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file name to search:");
        String fileName = scanner.nextLine();

        searchFile(new File(dirPath), fileName);
    }

    private static void searchFile(File dir, String fileName) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    searchFile(file, fileName);
                }
            }
        }
        System.out.println("File not found.");
    }
}