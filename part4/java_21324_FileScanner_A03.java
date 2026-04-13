import java.io.*;

public class java_21324_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        File[] hiddenFiles = file.listFiles(file1 -> file1.isHidden());

        if (hiddenFiles != null) {
            for (File hiddenFile : hiddenFiles) {
                if (hiddenFile.isFile() && hiddenFile.canRead()) {
                    FileReader reader = new FileReader(hiddenFile);
                    int character;

                    while ((character = reader.read()) != -1) {
                        System.out.print((char) character);
                    }
                    reader.close();
                }
            }
        }
    }
}