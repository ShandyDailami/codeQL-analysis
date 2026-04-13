import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02743_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File rootDirectory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        printFiles(rootDirectory, filter, "");
    }

    private static void printFiles(File directory, FileFilter filter, String indent) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                System.out.println(indent + file.getName());
                if (file.isDirectory()) {
                    printFiles(file, filter, indent + "  ");
                }
            }
        }
    }
}