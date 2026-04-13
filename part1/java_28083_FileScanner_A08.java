import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_28083_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File dir = new File(directoryPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        if (!dir.isDirectory()) {
            System.out.println("Given path is not a directory!");
            System.exit(1);
        }

        List<String> fileNames = getFileNames(dir, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Return true to include the file in the list
                // Return false to exclude it
                return true;
            }
        });

        for (String name : fileNames) {
            System.out.println(name);
        }

        scanner.close();
    }

    private static List<String> getFileNames(File dir, FileFilter filter) throws FileNotFoundException {
        List<String> fileNames = new ArrayList<>();

        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                } else if (file.isDirectory()) {
                    fileNames.addAll(getFileNames(file, filter));
                }
            }
        }

        return fileNames;
    }
}