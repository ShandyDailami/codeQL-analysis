import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_13548_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        try {
            FileScanner fileScanner = new FileScanner(file);
            fileScanner.startScanning();

            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.next());
            }

            fileScanner.stopScanning();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class FileScanner {
    private File file;

    public java_13548_FileScanner_A03(File file) {
        this.file = file;
    }

    public void startScanning() throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getPath());
        }
        // TODO: Implement file scanning logic here
    }

    public void stopScanning() {
        // TODO: Implement file scanning stop logic here
    }

    public String next() {
        // TODO: Implement file scanning next line logic here
        return null;
    }

    public boolean hasNext() {
        // TODO: Implement file scanning hasNext logic here
        return false;
    }
}