import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_06234_FileScanner_A03 {

    // This regular expression checks for basic file system path vulnerabilities
    private static final Pattern PATH_TRAVERSAL_REGEX = Pattern.compile("[a-zA-Z0-9_\\.\\\\\\/\\\\\\-]+");

    // This regular expression checks for command line arguments
    private static final Pattern COMMAND_LINE_REGEX = Pattern.compile("[a-zA-Z0-9_\\-\\.\\\\\\/\\\\\\\\\\\\\\\\\\ ]+");

    public static void main(String[] args) {

        // Check if args are empty
        if (args.length == 0) {
            System.out.println("Usage: SecureFileScanner <path>");
            System.exit(1);
        }

        // Check if path is a valid file or directory
        File file = new File(args[0]);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Invalid path");
            System.exit(1);
        }

        // Scan files in directory
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.canRead() && !isPathTraversal(f.getPath()) && !isCommandLine(f.getPath())) {
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }

    private static boolean isPathTraversal(String path) {
        return PATH_TRAVERSAL_REGEX.matcher(path).matches();
    }

    private static boolean isCommandLine(String path) {
        return COMMAND_LINE_REGEX.matcher(path).matches();
    }
}