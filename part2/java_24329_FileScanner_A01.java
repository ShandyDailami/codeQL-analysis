import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_24329_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir.getPath() + "/" + name);
                return file.isDirectory();
            }
        });

        if (files == null) {
            return;
        }

        for (File file : files) {
            System.out.println(file.getName());
        }

        scanner.close();
    }
}