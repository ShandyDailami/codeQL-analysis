import java.io.File;
import java.util.Scanner;

public class java_04699_FileScanner_A01 {
    private final File file;
    private final String targetName;

    public java_04699_FileScanner_A01(String filePath, String targetName) {
        file = new File(filePath);
        this.targetName = targetName;
    }

    public void scanFile() {
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] files = file.list();
                if (files != null) {
                    for (String fileName : files) {
                        if (fileName.equals(targetName)) {
                            System.out.println("File found: " + file.getAbsolutePath());
                        } else {
                            System.out.println("Looking in: " + file.getAbsolutePath());
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println("Looking in line: " + line);
                                if (line.contains(targetName)) {
                                    System.out.println("Target found in line!");
                                } else {
                                    System.out.println("Target not found in line!");
                                }
                            }
                            scanner.close();
                        }
                    }
                }
            } else {
                if (file.getName().equals(targetName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else {
                    System.out.println("Looking in: " + file.getAbsolutePath());
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Looking in line: " + line);
                        if (line.contains(targetName)) {
                            System.out.println("Target found in line!");
                        } else {
                            System.out.println("Target not found in line!");
                        }
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("File does not exist!");
        }
    }

    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner("/path/to/file", "targetName");
        scanner.scanFile();
    }
}