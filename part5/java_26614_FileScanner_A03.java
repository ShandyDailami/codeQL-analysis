import java.io.File;
import java.util.Scanner;

public class java_26614_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            searchFile(dir, "");
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void searchFile(File file, String prefix) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    if (f.getName().endsWith(".java")) {
                        System.out.println(prefix + f.getName());
                    }
                } else if (f.isDirectory()) {
                    searchFile(f, prefix + f.getName() + "/");
                }
            }
        }
    }
}