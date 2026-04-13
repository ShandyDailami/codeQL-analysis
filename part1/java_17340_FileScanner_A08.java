import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17340_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = input.nextLine();
        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        long length = file.length();
                        long sum = 0;
                        byte[] buffer = new byte[1024];
                        int nRead;
                        while ((nRead = file.read(buffer)) != -1) {
                            sum += nRead;
                            if (sum > length) {
                                throw new RuntimeException("File integrity failure!");
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The provided path was not found.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}