import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_20331_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String[] files = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        if (files != null) {
            for (String fileName : files) {
                File fileToRead = new File(fileName);
                if (fileToRead.exists()) {
                    System.out.println("Reading file: " + fileToRead.getPath());
                    // Add your code here to read the file and print its content.
                    // For example:
                    Scanner scanner = new Scanner(fileToRead);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}