import java.io.File;
import java.util.Scanner;

public class java_34934_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File[] rootDirectories = File.listRoots();
        for (File rootDirectory : rootDirectories) {
            File[] files = rootDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getPath().startsWith(directoryPath)) {
                        System.out.println(file.getPath());
                    }
                }
            }
        }

        scanner.close();
    }
}