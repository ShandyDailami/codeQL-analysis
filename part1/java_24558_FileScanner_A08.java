import java.io.File;
import java.util.Scanner;

public class java_24558_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listOfFiles = file.listFiles();
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        System.out.println(listOfFiles[i].getName());
                    }
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}