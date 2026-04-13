import java.io.File;
import java.util.Scanner;

public class java_22721_FileScanner_A03 {
    private static final String INSECURE_EXTENSIONS = "exe, bin, dll, jar";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] insecureFiles = directory.listFiles((dir, name) -> {
            String nameExtension = name.toLowerCase();
            return INSECURE_EXTENSIONS.contains(nameExtension);
        });

        if (insecureFiles != null) {
            for (File insecureFile : insecureFiles) {
                if (insecureFile.isFile()) {
                    System.out.println("Insecure file found: " + insecureFile.getAbsolutePath());
                } else {
                    System.out.println("Insecure directory found: " + insecureFile.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No insecure files or directories found in the directory " + directoryPath);
        }

        scanner.close();
    }
}