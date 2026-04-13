import java.io.*;
import java.util.*;

public class java_24947_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_directory");
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    listFiles(f);
                } else {
                    if (f.getName().endsWith(".txt")) {
                        try {
                            FileReader reader = new FileReader(f);
                            BufferedReader bufferedReader = new BufferedReader(reader);
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                if (containsSensitiveInformation(line)) {
                                    System.out.println("Found sensitive information in file: " + f.getName());
                                }
                            }
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static boolean containsSensitiveInformation(String line) {
        String sensitiveInfo = "sensitive information";
        return line.contains(sensitiveInfo);
    }

    private static void listFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    listFiles(f);
                } else {
                    if (f.getName().endsWith(".txt")) {
                        System.out.println("Found file: " + f.getName());
                    }
                }
            }
        }
    }
}