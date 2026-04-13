import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_26901_FileScanner_A03 {
    private static final Set<String> VALID_EXTENSIONS = new HashSet<>(Arrays.asList("jpg", "png", "jpeg", "gif", "bmp"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isImageFile(file)) {
                    System.out.println("Valid image file: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }

    private static boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        int lastDot = name.lastIndexOf(".");

        // If no dot found, file is not an image
        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1);
        return VALID_EXTENSIONS.contains(extension);
    }
}