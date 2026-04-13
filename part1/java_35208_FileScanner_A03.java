import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35208_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String name : list) {
                File file2 = new File(name);
                if (file2.isFile() && file2.length() < 1000) {
                    try {
                        Scanner scanner = new Scanner(file2);
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}