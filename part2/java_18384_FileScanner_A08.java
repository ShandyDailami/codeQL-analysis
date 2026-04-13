import java.io.File;
import java.util.Scanner;

public class java_18384_FileScanner_A08 {
    private static final String WORD = "A08_IntegrityFailure";

    public static void main(String[] args) {
        File currentDir = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scanning files in current directory...");
        searchFiles(currentDir, WORD);

        System.out.println("\nPress enter to exit...");
        scanner.nextLine();
    }

    private static void searchFiles(File dir, String word) {
        if (dir.listFiles() == null) return;

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                searchFiles(file, word);
            } else if (file.getName().contains(word)) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }
    }
}