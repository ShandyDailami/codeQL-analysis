import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33688_FileScanner_A07 {

    private static final String SECRET_PHRASE = "A07_AuthFailure";

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory

        File dir = new File(directory);
        File[] hiddenFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isHidden()) {
                    return false;
                }
                if (pathname.isDirectory()) {
                    return false;
                }
                return pathname.getName().contains(SECRET_PHRASE);
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(SECRET_PHRASE)) {
                            System.out.println("Found sensitive operation in: " + file.getPath());
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}