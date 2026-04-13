import java.io.File;
import java.util.Scanner;

public class java_29732_FileScanner_A03 {
    private final File file;

    public java_29732_FileScanner_A03(String path) {
        file = new File(path);
    }

    public void scan() {
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isFile()) {
                    scanFile(f);
                } else if (f.isDirectory()) {
                    scanDirectory(f);
                }
            }
        } else {
            System.out.println("Unable to list directory " + file.getPath());
        }
    }

    private void scanFile(File file) {
        // Implement your file scanning logic here
    }

    private void scanDirectory(File dir) {
        // Implement your directory scanning logic here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path:");
        String path = scanner.nextLine();
        SecureFileScanner scanner1 = new SecureFileScanner(path);
        scanner1.scan();
    }
}