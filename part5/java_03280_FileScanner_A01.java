import java.io.*;

public class java_03280_FileScanner_A01 {
    private final String directoryPath;

    public java_03280_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory();
                }
            }
        }
    }

    private void printFileDetails(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureFileScanner(".").scanDirectory();
    }
}