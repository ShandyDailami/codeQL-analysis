import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36787_FileScanner_A03 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("/path/to/directory"); // Set your directory
        scanner.setFileType("txt"); // Set your file type
        scanner.start();
    }

    private static class FileScanner {
        private String directory;
        private String fileType;
        private Scanner scanner;

        public void setDirectory(String directory) {
            this.directory = directory;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public void start() {
            File dir = new File(directory);
            File[] listOfFiles = dir.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(fileType)) {
                    try {
                        scanner = new Scanner(file);
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
        }
    }
}