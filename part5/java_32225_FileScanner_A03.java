import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32225_FileScanner_A03 {

    private String filePath;

    public java_32225_FileScanner_A03(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}