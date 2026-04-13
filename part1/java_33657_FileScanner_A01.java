import java.io.File;
import java.util.Scanner;

public class java_33657_FileScanner_A01 {
    private static final String ROOT_DIR = "C:\\";
    private static final String SEARCH_FOR = "A01_BrokenAccessControl";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File rootDir = new File(ROOT_DIR);
        File[] hiddenFiles = rootDir.listFiles((dir, name) -> name.endsWith(SEARCH_FOR));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                if (file.isFile()) {
                    if (file.getName().contains(SEARCH_FOR)) {
                        System.out.println("File: " + file.getAbsolutePath() + " contains sensitive information.");
                    }
                } else {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }
}