import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_21209_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        Set<File> files = new HashSet<>();
        findFiles(new File(directoryPath), fileExtension, files);

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    private static void findFiles(File directory, String extension, Set<File> files) {
        File[] directoryContents = directory.listFiles();
        if (directoryContents != null) {
            for (File file : directoryContents) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    findFiles(file, extension, files);
                }
            }
        }
    }
}