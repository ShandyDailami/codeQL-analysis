import java.io.File;
import java.util.Scanner;

public class java_08691_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            listFiles(file, "");
        } else {
            System.out.println("Directory does not exist");
        }
    }

    private static void listFiles(File file, String indentation) {
        for (int i = 0; i < indentation.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    listFiles(f, indentation + "--");
                }
            }
        }
    }
}