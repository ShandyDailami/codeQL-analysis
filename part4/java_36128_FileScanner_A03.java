import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class java_36128_FileScanner_A03 {

    private static final String DIRECTORY = "C:/YourDirectory/";  // your directory
    private static final String SECURITY_INJECTION = "security injection";
    private static AtomicBoolean injectionFound = new AtomicBoolean(false);

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = s.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }
        findSecurityInjection(directory);
        if (!injectionFound.get()) {
            System.out.println("No security injections found.");
        }
    }

    private static void findSecurityInjection(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    findSecurityInjection(file);
                } else if (file.getName().endsWith(".java")) {
                    try {
                        processFile(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void processFile(File file) throws Exception {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine());
        }
        scanner.close();
        if (content.toString().contains(SECURITY_INJECTION)) {
            injectionFound.set(true);
            System.out.println("Security injection found in " + file.getPath());
        }
    }
}