import java.io.File;
import java.util.Scanner;

public class java_05067_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        listFilesAndSizes(dir, 0);
    }

    private static void listFilesAndSizes(File dir, int depth) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (depth < 10) {
                        listFilesAndSizes(file, depth + 1);
                    }
                } else {
                    System.out.println(getIndentation(depth) + "- " + file.getName() + " (" + file.length() + " bytes)");
                }
            }
        }
    }

    private static String getIndentation(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}