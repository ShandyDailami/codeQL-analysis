import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19349_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning directory: " + directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && hasValidIntegrity(file)) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                    }
                }
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static boolean hasValidIntegrity(File file) {
        try {
            long fileLength = file.length();
            long sum = 0L;
            int byteRead = 0;
            FileChannel channel = new FileInputStream(file).getChannel();

            while (sum < fileLength && (byteRead = channel.read(buffer, cursor)) != -1) {
                sum += byteRead;
                System.out.println("Sum: " + sum + ", byteRead: " + byteRead);
            }

            channel.close();
            return sum == fileLength;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static final int BUFFER_SIZE = 1024;
    private static final FileChannel.MapMode MAP_MODE = FileChannel.MapMode.READ_ONLY;
    private static final FileChannel buffer = FileChannel.open(Paths.get("temp_file"), MAP_MODE, BUFFER_SIZE);
    private static long cursor = 0L;
}