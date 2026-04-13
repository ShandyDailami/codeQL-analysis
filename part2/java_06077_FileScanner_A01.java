import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06077_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            List<String> fileList = getFiles(file, new ArrayList<>());
            for (String s : fileList) {
                System.out.println(s);
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static List<String> getFiles(File file, List<String> list) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    list.add(f.getPath());
                } else if (f.isDirectory()) {
                    getFiles(f, list);
                }
            }
        }
        return list;
    }
}