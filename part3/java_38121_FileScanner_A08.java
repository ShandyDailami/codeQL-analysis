import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_38121_FileScanner_A08 {
    private static Set<String> visitedFiles = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        visitFiles(dir);
        System.out.println("Visited files: " + visitedFiles.size());
    }

    private static void visitFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    visitFile(f);
                } else if (f.isDirectory()) {
                    visitFiles(f);
                }
            }
        }
    }

    private static void visitFile(File file) {
        if (!visitedFiles.contains(file.getPath())) {
            visitedFiles.add(file.getPath());
            System.out.println("Visited: " + file.getPath());
        }
    }
}