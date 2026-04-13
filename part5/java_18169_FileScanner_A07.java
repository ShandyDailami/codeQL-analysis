import java.io.File;
import java.util.Scanner;

public class java_18169_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File root = new File(dir);
        findFile(root, fileName);
    }

    private static void findFile(File root, String fileName) {
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    findFile(file, fileName);
                }
            }
        } else if (root.getName().equals(fileName) && root.canRead()) {
            System.out.println("File found: " + root.getAbsolutePath());
        }
    }
}