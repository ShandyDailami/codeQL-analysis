import java.io.File;
import java.util.Scanner;

public class java_08330_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.nextLine();

        File file = new File(dir);

        if (file.isDirectory()) {
            listFiles(file, 0);
        } else {
            System.out.println("Not a directory");
        }
    }

    private static void listFiles(File file, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    listFiles(f, indent + 1);
                } else {
                    for (int i = 0; i < indent + 1; i++) {
                        System.out.print("  ");
                    }
                    System.out.println(f.getName());
                }
            }
        }
    }
}