import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class java_16690_FileScanner_A03 {
    private static final String DIR = "C:\\temp";
    private static final String EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        AtomicInteger fileCount = new AtomicInteger(0);
        File[] matchingFiles = new File(DIR).listFiles((dir, name) -> name.matches(EXTENSION));
        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                new Thread(new FileScannerTask(file, fileCount)).start();
            }
        }
        System.out.println("Number of files scanned: " + fileCount.get());
    }
}

class FileScannerTask implements Runnable {
    private final File file;
    private final AtomicInteger fileCount;

    public java_16690_FileScanner_A03(File file, AtomicInteger fileCount) {
        this.file = file;
        this.fileCount = fileCount;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add security-sensitive operation here. For example, scan for known malicious strings.
            }
            fileCount.incrementAndGet();
        } catch (Exception e) {
            // Handle exception here.
        }
    }
}