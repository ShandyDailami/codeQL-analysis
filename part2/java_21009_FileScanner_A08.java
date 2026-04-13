import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_21009_FileScanner_A08 {

    private static final String DIRECTORY_TO_SCAN = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);

        if (directory.exists() && directory.isDirectory()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the security token:");
            String token = scanner.nextLine();

            if (token.equals("YOUR_SECURITY_TOKEN")) {
                File[] files = directory.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".sec");
                    }
                });

                if (files != null) {
                    Arrays.stream(files).forEach(file -> {
                        System.out.println("Access granted to: " + file.getName());
                    });
                } else {
                    System.out.println("No files with .sec extension found.");
                }
            } else {
                System.out.println("Access denied.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}