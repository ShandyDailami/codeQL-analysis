import java.io.*;
import java.util.*;

public class java_28194_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");
        File[] hiddenFiles = file.listFiles(File::getHiddenFiles);

        if(hiddenFiles != null) {
            for(File hiddenFile : hiddenFiles) {
                if(hiddenFile.isFile() && hiddenFile.canRead()) {
                    readFile(hiddenFile);
                }
            }
        }
    }

    private static void readFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}