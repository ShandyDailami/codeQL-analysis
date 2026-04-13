import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28466_FileScanner_A08 {
    private String directory;
    private String extension;

    public java_28466_FileScanner_A08(String directory, String extension) {
        this.directory = directory;
        this.extension = extension;
    }

    public void scanFiles() {
        File file = new File(directory);
        File[] listOfFiles = file.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.getName().endsWith(extension)) {
                try {
                    Scanner scanner = new Scanner(listOfFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                        // Here you can add your security-sensitive operations related to A08_IntegrityFailure.
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner(".", ".txt");
        fileScanner.scanFiles();
    }
}