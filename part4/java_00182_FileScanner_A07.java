import java.io.File;
import java.util.Scanner;

public class java_00182_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        listFiles(directory, "");
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().startsWith(".")) {
                        System.out.println(indent + "[" + file.getName() + "]");
                    } else {
                        listFiles(file, indent + "  ");
                    }
                } else {
                    if (!file.getName().startsWith(".")) {
                        System.out.println(indent + "- " + file.getName());
                    }
                }
            }
        }
    }
}