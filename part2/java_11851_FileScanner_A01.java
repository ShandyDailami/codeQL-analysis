import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_11851_FileScanner_A01 {

    private static final Set<String> LEGAL_FILE_EXTENSIONS = new HashSet<>(Arrays.asList(".txt", ".jpg", ".png", ".jpeg", ".mp3", ".mp4", ".avi"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Directory is empty.");
            return;
        }

        for (File file : files) {
            if (file.isFile() && LEGAL_FILE_EXTENSIONS.contains(file.getPath().substring(file.getPath().lastIndexOf(".") + 1))) {
                System.out.println(file.getPath());
            }
        }
    }
}