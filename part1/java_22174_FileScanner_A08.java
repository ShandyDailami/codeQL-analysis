import java.io.*;

public class java_22174_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:/temp");
        File[] hiddenFiles = file.listFiles(File::getFileFilter);

        for (File hiddenFile : hiddenFiles) {
            if (hiddenFile.isHidden()) {
                if (hiddenFile.getName().endsWith(".properties")) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(hiddenFile));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("username")) {
                                System.out.println("Potential security risk detected: " + hiddenFile.getAbsolutePath());
                            }