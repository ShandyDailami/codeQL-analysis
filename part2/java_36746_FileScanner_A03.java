import java.io.*;

public class java_36746_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        File[] hiddenFiles = file.listFiles(file -> file.isHidden());

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.getName().endsWith(".class")) {
                    // Removing the .class extension and checking if the file is a security-sensitive operation
                    String fileName = hiddenFile.getName().replace(".class", "");
                    if (fileName.startsWith("A03_")) {
                        System.out.println("Security-Sensitive operation detected in: " + hiddenFile.getPath());
                    }
                }
            }
        }
    }
}