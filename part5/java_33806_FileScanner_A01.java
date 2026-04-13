import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33806_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(new File(directoryPath));
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory() || (pathname.isFile() && !pathname.getName().startsWith("."));
            }
        });

        if (files != null) {
            for (File file : files) {
                scanDirectory(file);
            }
        }

        try {
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}