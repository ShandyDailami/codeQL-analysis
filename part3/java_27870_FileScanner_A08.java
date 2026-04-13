import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27870_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(new File(path));
        fileScanner.start();
    }
}

class FileScanner {
    private File file;

    public java_27870_FileScanner_A08(File file) {
        this.file = file;
    }

    public void start() {
        printFiles(file, 0);
    }

    private void printFiles(File file, int depth) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    printFiles(child, depth + 1);
                }
            }
        } else {
            printFile(file, depth);
        }
    }

    private void printFile(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());
    }
}