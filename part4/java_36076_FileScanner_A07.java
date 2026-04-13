import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_36076_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            search(directory, args[0]);
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void search(File directory, String name) {
        File[] list = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(name);
            }
        });

        for (File file : list) {
            if (file.isFile()) {
                if (file.getName().equals(name)) {
                    System.out.println("File found: " + file.getPath());
                }
            } else if (file.isDirectory()) {
                search(file, name);
            }
        }
    }
}