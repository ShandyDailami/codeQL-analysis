import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_34412_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory to scan: ");
        String directory = input.nextLine();

        scanDirectory(new File(directory));
    }

    private static void scanDirectory(File directory) {
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Cannot read directory!");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    try {
                        if (file.getCanonicalPath().endsWith(".class")) {
                            FileReader reader = new FileReader(file);
                            int r;
                            while ((r = reader.read()) != -1) {
                                System.out.print((char) r);
                            }
                            reader.close();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getName());
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }
}