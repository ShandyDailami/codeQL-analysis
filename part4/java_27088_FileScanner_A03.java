import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Permission;
import java.util.Arrays;

public class java_27088_FileScanner_A03 {

    public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return true;
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        FileReader reader = new FileReader(file);
                        int c;
                        while ((c = reader.read()) != -1) {
                            System.out.print((char) c);
                        }
                        reader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}