import java.io.*;

public class java_23955_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner that scans files in the current directory
            FileScanner scanner = new FileScanner(new File("."));
            
            // Use a try-with-resources statement to automatically close the scanner when done
            try (scanner) {
                // For each file, print its name and size
                for (File file : scanner) {
                    System.out.printf("Found file: %s (size: %d bytes)\n", file.getName(), file.length());
                    
                    // Check if the file's name contains the word 'integrity'
                    if (file.getName().contains("integrity")) {
                        System.out.println("Integrity failure detected in: " + file.getName());
                        
                        // Get the file's parent directory
                        File parentDir = file.getParentFile();
                        
                        // Print a message that integrity failure has occurred
                        System.out.println("Integrity failure has occurred in the directory: " + parentDir.getName());
                        
                        // Print the parent directory's name
                        System.out.println("Parent directory name: " + parentDir.getName());
                        
                        // Print the integrity failure details
                        System.out.println("Please check the details in the file: " + file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException e) {
            // Handle I/O exceptions
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

class FileScanner extends java.io.FileFilter implements Iterable<File> {
    private File file;
    
    public java_23955_FileScanner_A08(File file) {
        this.file = file;
    }
    
    @Override
    public boolean accept(File pathname) {
        // Return true if the pathname is in the file's directory
        return pathname.getParent().equals(file.getParent());
    }
    
    @Override
    public Iterator<File> iterator() {
        return new FileIterator(file);
    }
}

class FileIterator implements Iterator<File> {
    private File[] files;
    private int index;
    
    public java_23955_FileScanner_A08(File file) {
        // Get a list of all files in the file's directory
        files = file.listFiles();
        index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < files.length;
    }
    
    @Override
    public File next() {
        return files[index++];
    }
}