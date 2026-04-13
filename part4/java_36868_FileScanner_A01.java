import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_36868_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        findTextFiles(dir, ".txt");
    }

    private static void findTextFiles(File dir, String extension) {
        File[] files = dir.listFiles((d, name) -> name.endsWith(extension));
        if (files != null) {
            Arrays.stream(files).forEach(Main::printFileInfo);
        }
    }

    private static void printFileInfo(File file) {
        System.out.printf("File: %s%n", file.getAbsolutePath());
        System.out.printf("Last modified: %s%n", file.lastModified());
        System.out.printf("Size: %d bytes%n", file.length());
    }
}