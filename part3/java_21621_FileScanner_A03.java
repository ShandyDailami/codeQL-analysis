import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_21621_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(fileExtension);
                }
            });

            if (files != null) {
                for (File file : files) {
                    try (FileReader reader = new FileReader(file)) {
                        int r;
                        while ((r = reader.read()) != -1) {
                            System.out.print((char) r);
                        }
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}