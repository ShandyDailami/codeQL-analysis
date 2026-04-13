import java.io.File;
import java.util.Scanner;

public class java_31128_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory contains:");
                String[] list = file.list();
                for (String s : list) {
                    File f = new File(file, s);
                    if (f.isFile()) {
                        System.out.println(s);
                    }
                }
            } else {
                System.out.println("It's not a directory");
            }
        } else {
            System.out.println("Directory not found");
        }
    }
}