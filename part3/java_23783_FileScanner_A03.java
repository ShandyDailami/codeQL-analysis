import java.io.File;
import java.util.Scanner;

public class java_23783_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning(".", ".*injection.*");
    }
}

class FileScanner {
    public void startScanning(String directory, String keyword) {
        File[] foundFiles = new File(directory).listFiles();

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile() && file.canRead() && containsKeyword(file, keyword)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    startScanning(file.getAbsolutePath(), keyword);
                }
            }
        }
    }

    private boolean containsKeyword(File file, String keyword) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}