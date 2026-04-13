import java.io.File;
import java.util.Scanner;

public class java_37159_FileScanner_A03 {

    private String baseDir;
    private Scanner scanner;

    public java_37159_FileScanner_A03(String baseDir) {
        this.baseDir = baseDir;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Enter file name to search:");
        String fileName = this.scanner.next();

        File file = new File(this.baseDir + "/" + fileName);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("File content:");
                    System.out.println(this.readFileContent(file));
                } else {
                    System.out.println("Error: File is not readable.");
                }
            } else {
                System.out.println("Error: Path is not a file.");
            }
        } else {
            System.out.println("Error: File does not exist.");
        }

        this.scanner.close();
    }

    private String readFileContent(File file) {
        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        new SecureFileScanner(".").start();
    }
}