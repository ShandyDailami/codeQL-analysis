import java.io.*;
import java.util.*;

public class java_14960_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File(".");
        File[] hiddenFiles = file.listFiles(file -> file.isHidden());

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile() && hiddenFile.canRead()) {
                    try (FileReader reader = new FileReader(hiddenFile)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            System.out.print((char) r);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}