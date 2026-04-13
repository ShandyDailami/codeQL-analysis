import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05625_FileScanner_A03 {

    public static void main(String[] args) {
        String dirPath = "path_to_directory"; // specify the directory path

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt"); // filter for txt files
            }
        };

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] list = dir.list();

            for (String fileName : list) {
                File file = new File(dirPath, fileName);

                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        } else {
            System.out.println("Directory not found: " + dirPath);
        }
    }
}