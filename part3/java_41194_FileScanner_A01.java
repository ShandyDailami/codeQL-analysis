import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41194_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory");
    }
}

class FileScanner {
    public void startScanning(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (File f : list) {
                    if (f.isDirectory()) {
                        startScanning(f.getPath());
                    } else {
                        readFile(f.getPath());
                    }
                }
            } else {
                readFile(path);
            }
        } else {
            System.out.println("The specified file does not exist.");
        }
    }

    public void readFile(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + path + " was not found.");
        }
    }
}