import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39699_FileScanner_A03 {
    private static final String DIRECTORY = "src/main/java";
    private static final String FILE_EXTENSION = ".java";

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(DIRECTORY);
        File[] javaFiles = dir.listFiles((dir2, name) -> name.endsWith(FILE_EXTENSION));
        if (javaFiles == null) {
            System.out.println("No Java files found in the directory.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operation you want to perform: ");
        String operation = scanner.next();
        switch (operation) {
            case "list":
                listFiles(javaFiles);
                break;
            case "count":
                countFiles(javaFiles);
                break;
            default:
                System.out.println("Invalid operation.");
        }
        scanner.close();
    }

    private static void listFiles(File[] javaFiles) {
        for (File file : javaFiles) {
            System.out.println(file.getName());
        }
    }

    private static void countFiles(File[] javaFiles) {
        System.out.println("Number of Java files: " + javaFiles.length);
    }
}