import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18430_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/path/to/file/or/directory"; // replace with your path
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File f : listFiles) {
                        if (f.isFile()) {
                            Scanner scanner = new Scanner(f);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // perform some sensitive operation on each line
                                System.out.println("Sensitive operation on: " + line);
                            }
                            scanner.close();
                        } else if (f.isDirectory()) {
                            System.out.println("Skipping directory: " + f.getPath());
                        }
                    }
                }
            } else if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // perform some sensitive operation on each line
                    System.out.println("Sensitive operation on: " + line);
                }
                scanner.close();
            }
        } else {
            System.out.println("File or directory does not exist: " + path);
        }
    }
}