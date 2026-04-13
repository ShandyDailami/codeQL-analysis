import java.io.File;
import java.util.Scanner;

public class java_16879_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);
        findFile(directory, "example.txt", scanner);
    }

    public static void findFile(File directory, String name, Scanner scanner) {
        File[] list = directory.listFiles();
        if (list == null) return;
        for (File file : list) {
            if (file.getName().equals(name)) {
                System.out.println("File found: " + file.getPath());
                if (file.isFile()) {
                    System.out.println("File size: " + file.length() + " bytes");
                } else {
                    System.out.println("Directory: " + file.getPath());
                    findFile(file, name, scanner);
                }
            }
        }
    }
}