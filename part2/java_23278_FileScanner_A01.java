import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23278_FileScanner_A01 {
    private File file;

    public java_23278_FileScanner_A01(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        if (!this.file.exists()) {
            throw new FileNotFoundException("File not found!");
        }
    }

    public String readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine());
        }
        scanner.close();
        return content.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        BrokenAccessControlScanner scanner = new BrokenAccessControlScanner("src/main/resources/broken.txt");
        String content = scanner.readFile();
        System.out.println(content);
    }
}