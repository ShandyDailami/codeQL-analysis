import java.io.File;
import java.util.Scanner;

public class java_00959_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension (without dot):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith("." + fileExtension));

        if (files == null) {
            System.out.println("No files found with the specified extension in the directory and its subdirectories");
            return;
        }

        System.out.println("Files with the extension " + fileExtension + ":");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}