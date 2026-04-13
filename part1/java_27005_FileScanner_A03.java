import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27005_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\path_to_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (containsInjection(line)) {
                            System.out.println("Found injection in: " + file.getAbsolutePath());
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean containsInjection(String line) {
        // Here you can add your security-sensitive operations related to A03_Injection
        return line.contains("injection") || line.contains("Injection") || line.contains("INSERT") || line.contains("delete");
    }
}