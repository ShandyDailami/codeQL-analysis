import java.io.File;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_32665_FileScanner_A07 {
    private BlockingQueue<File> queue = new LinkedBlockingQueue<>();

    public java_32665_FileScanner_A07() {
        new FileScannerThread().start();
    }

    private class FileScannerThread extends Thread {
        @Override
        public void run() {
            try {
                File[] rootDirectoryFiles = File.listRoots();
                for (File rootDirectoryFile : rootDirectoryFiles) {
                    enqueueAll(rootDirectoryFile);
                }
                queue.put(null); //Signal the main thread to stop.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void enqueueAll(File rootDirectoryFile) {
            File[] files = rootDirectoryFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        enqueueAll(file);
                    } else if (isSecuritySensitive(file)) {
                        queue.put(file);
                    }
                }
            }
        }

        private boolean isSecuritySensitive(File file) {
            // Implement security-sensitive operation here.
            // For now, let's return false.
            return false;
        }
    }

    public BlockingQueue<File> getQueue() {
        return queue;
    }

    public static void main(String[] args) {
        new SecurityCheck();
    }
}