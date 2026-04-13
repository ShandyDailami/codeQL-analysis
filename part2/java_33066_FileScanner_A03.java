import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class java_33066_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "C:\\path\\to\\directory"; // Replace with your directory path
        String searchString = "secret"; // Replace with the string you're looking for

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] foundFiles = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isFile()) {
                        try {
                            return readFile(pathname, searchString);
                        } catch (IOException e) {
                            System.err.println("Error reading file: " + pathname.getAbsolutePath());
                            return false;
                        }
                    }
                    return true;
                }
            });

            for (File foundFile : foundFiles) {
                System.out.println("Found file: " + foundFile.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    private static boolean readFile(File file, String searchString) throws IOException {
        String fileContent = new String(java.nio.file.Files.readAllBytes(file.toPath()));
        return fileContent.contains(searchString);
    }
}