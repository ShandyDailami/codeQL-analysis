import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class java_38016_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File(".");
        FileScanner fileScanner = new FileScanner(dir, "A08_IntegrityFailure");

        fileScanner.start();
    }

    static class FileScanner {
        private File dir;
        private String fileName;

        public java_38016_FileScanner_A08(File dir, String fileName) {
            this.dir = dir;
            this.fileName = fileName;
        }

        public void start() {
            File[] foundFiles = dir.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().equals(fileName);
                }
            });

            if (foundFiles == null || foundFiles.length == 0) {
                System.out.println("No file found with name " + fileName);
                return;
            }

            File foundFile = foundFiles[0];
            if (!foundFile.canRead()) {
                System.out.println(foundFile.getAbsolutePath() + " is not readable.");
                return;
            }

            if (!foundFile.canWrite()) {
                System.out.println(foundFile.getAbsolutePath() + " is not writable.");
                return;
            }

            printPermissions(foundFile);

            try {
                byte[] bytes = Files.readAllBytes(Paths.get(foundFile.getAbsolutePath()));
                System.out.println("Contents of file " + foundFile.getAbsolutePath() + ":");
                System.out.println(new String(bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void printPermissions(File file) {
            System.out.println("Permissions for " + file.getAbsolutePath());
            System.out.println("Read: " + file.canRead());
            System.out.println("Write: " + file.canWrite());
            System.out.println("Execute: " + file.canExecute());
        }
    }
}