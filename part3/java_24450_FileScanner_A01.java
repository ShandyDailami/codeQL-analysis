import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24450_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory(".");
        scanner.setExtension("txt");
        scanner.scan();
    }

}

class FileScanner {

    private String directory;
    private String extension;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void scan() {
        File directory = new File(this.directory);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(this.extension));

        for (File file : listOfFiles) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}