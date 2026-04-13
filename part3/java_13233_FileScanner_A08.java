import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class java_13233_FileScanner_A08 {

    public static void main(String[] args) {
        File startingDir = new File(".");
        File[] hiddenFiles = startingDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                try {
                    readFile(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}