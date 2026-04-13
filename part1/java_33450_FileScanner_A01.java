import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class java_33450_FileScanner_A01 {

    private static final List<String> WHITELIST = Arrays.asList("target", "example", "src");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) {
            for (File file : filesInDirectory) {
                if (file.getName().equals(fileName)) {
                    if (isFileAllowed(file.getName())) {
                        System.out.println("File " + file.getName() + " found and is allowed.");
                    } else {
                        System.out.println("File " + file.getName() + " found but not allowed.");
                    }
                    break;
                }
            }
        }
        scanner.close();
    }

    private static boolean isFileAllowed(String fileName) {
        for (String whitelistEntry : WHITELIST) {
            if (fileName.contains(whitelistEntry)) {
                return true;
            }
        }
        return false;
    }
}