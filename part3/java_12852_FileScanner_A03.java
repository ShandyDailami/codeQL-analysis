import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_12852_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                printFileInfo(file);
            }
        }

        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() && o2.isFile()) {
                return -1;
            }
            if (o1.isFile() && o2.isDirectory()) {
                return 1;
            }
            return o1.compareTo(o2);
        });

        System.out.println("\nSorted files:");
        for (File file : files) {
            if (file.isFile()) {
                printFileInfo(file);
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.printf("Name: %s, Size: %d bytes, Created: %s%n",
                file.getName(), file.length(), file.lastModified());
    }
}