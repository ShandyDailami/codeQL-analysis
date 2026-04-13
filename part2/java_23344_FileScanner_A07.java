import java.io.File;
import java.io.FileNotFoundException;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Scanner;

public class java_23344_FileScanner_A07 {

    private static SecurityManager sm = new SecurityManager() {
        @Override
        public boolean checkPermission(Permission perm) {
            return perm.getName().equals("getClass");
        }
    };

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/authFailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}