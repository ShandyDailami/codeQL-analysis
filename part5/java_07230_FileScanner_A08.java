import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07230_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Scanning for .txt files...");
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    try {
                        if (validateFileIntegrity(txtFile)) {
                            System.out.println("File " + txtFile.getName() + " has integrity.");
                        } else {
                            System.out.println("Potential integrity failure detected in file " + txtFile.getName());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error reading file " + txtFile.getName());
                    }
                }
            } else {
                System.out.println("No .txt files found in " + dirPath);
            }
        } else {
            System.out.println(dirPath + " is not a valid directory.");
        }

        scanner.close();
    }

    private static boolean validateFileIntegrity(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        long length = file.length();
        long sum = 0L;
        byte[] buffer = new byte[1024];
        int nRead = 0;

        while ((nRead = fis.read(buffer)) != -1) {
            sum += nRead;
            if (sum != length) {
                throw new FileNotFoundException("File integrity failure detected");
            }
        }

        fis.close();
        return sum == length;
    }
}