import java.io.File;
import java.util.Arrays;

public class java_14000_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner();
    }

    public static void FileScanner() {
        // We'll assume current working directory as a safe place
        String path = System.getProperty("user.dir");
        File file = new File(path);

        File[] listOfFiles = file.listFiles();

        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(System.out::println);
        }
    }
}