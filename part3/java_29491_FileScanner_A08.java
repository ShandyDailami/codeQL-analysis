import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29491_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File(".");
        FileScanner scanner = new FileScanner(dir, new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("security");
            }
        });

        try {
            Scanner scan = new Scanner(scanner.getFile());
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class FileScanner {

    private File file;
    private FileFilter filter;

    public java_29491_FileScanner_A08(File file, FileFilter filter) {
        this.file = file;
        this.filter = filter;
    }

    public File getFile() throws FileNotFoundException {
        return file;
    }
}