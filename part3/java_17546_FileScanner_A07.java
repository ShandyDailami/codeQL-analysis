import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Scanner;

public class java_17546_FileScanner_A07 {

    public static void main(String[] args) {
        SecurityManager sm = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if ("A07_AuthFailure".equals(perm.getName())) {
                    throw new SecurityException("Auth Failure");
                }
            }
        };
        System.setSecurityManager(sm);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file type: ");
        String fileType = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileType));

        if (files != null) {
            for (File file : files) {
                try (FileReader reader = new FileReader(file)) {
                    int content;
                    while ((content = reader.read()) != -1) {
                        System.out.print((char) content);
                    }
                    System.out.println();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getPath());
                }
            }
        } else {
            System.out.println("No files found of the type: " + fileType);
        }

        scanner.close();
    }

}