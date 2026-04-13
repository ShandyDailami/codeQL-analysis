import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37954_FileScanner_A03 {
    private String[] fileTypes = {"txt", "doc", "docx", "pdf", "png", "jpg", "jpeg", "mp3", "mp4"};

    public void scan(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile()) {
                            String name = f.getName();
                            String extension = name.substring(name.lastIndexOf(".") + 1);
                            if (Arrays.asList(fileTypes).contains(extension)) {
                                System.out.println("File found: " + f.getName());
                            }
                        } else {
                            System.out.println("Directory found: " + f.getName());
                            scan(f.getPath());
                        }
                    }
                }
            } else {
                System.out.println("File found: " + file.getName());
            }
        } else {
            System.out.println("Path not found: " + path);
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the path: ");
        String path = scan.nextLine();
        scanner.scan(path);
    }
}