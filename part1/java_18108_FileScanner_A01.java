import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_18108_FileScanner_A01 {
    private static final String SECRET_DIRECTORY = "secret";

    public static void main(String[] args) {
        File file = new File(".");
        SecurityScanner scanner = new SecurityScanner();
        scanner.scan(file, scanner);
    }

    private void scan(File file, SecurityScanner scanner) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        for (File sourceFile : listFiles) {
            if (sourceFile.getAbsolutePath().endsWith(".java")) {
                System.out.println("Checking source file: " + sourceFile.getAbsolutePath());
                scanner.checkSourceFile(sourceFile);
            }
        }

        File[] listFiles1 = file.listFiles();
        Arrays.sort(listFiles1);
        for (File childFile : listFiles1) {
            if (childFile.isDirectory()) {
                scan(childFile, scanner);
            }
        }
    }

    private void checkSourceFile(File sourceFile) {
        try {
            Scanner scanner = new Scanner(sourceFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("secret")) {
                    System.out.println("Broken access control violation detected in: " + sourceFile.getAbsolutePath());
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}