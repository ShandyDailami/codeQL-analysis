import java.io.File;
import java.util.Scanner;

public class java_34286_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        findTextFiles(directory, ".txt");
    }

    private static void findTextFiles(File directory, String extension) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                findTextFiles(file, extension);
            }
        }
    }
}