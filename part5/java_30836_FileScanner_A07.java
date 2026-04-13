import java.io.File;
import java.util.Scanner;

public class java_30836_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        File root = new File(path);
        listFiles(root, 0);
    }

    private static void listFiles(File file, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("--");
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                listFiles(f, indent + 1);
            }
        }
    }
}