import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_36976_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // Replace with your directory path

        File directory = new File(directoryPath);

        // This is a simple filter to only get .txt files
        FileFilter txtFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // This will list all .txt files in the specified directory
        File[] txtFiles = directory.listFiles(txtFilter);

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(file -> {
                // This is a simple example of a security-sensitive operation
                System.out.println("Reading file: " + file.getName());

                // Reading and printing the content of the file
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                   
                        // This is a simple example of a security-sensitive operation
                        // We are just printing the content. Realistically, you'd likely want to hash this line
                        // and compare it to a stored hash to ensure the integrity of the file.
                    }
                    scanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                    e.printStackTrace();
                }
            });
        }
    }
}