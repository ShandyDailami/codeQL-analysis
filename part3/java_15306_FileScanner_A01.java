import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15306_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            Arrays.stream(files)
                    .filter(file -> file.isFile() && isFileAccessible(file))
                    .forEach(file -> System.out.println("File name: " + file.getName()));
        } else {
            System.out.println("No files found in the directory!");
        }
    }

    private static boolean isFileAccessible(File file) {
        return file.canRead();
    }
}