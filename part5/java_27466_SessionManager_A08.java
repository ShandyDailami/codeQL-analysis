import java.io.*;
import java.nio.file.*;

public class java_27466_SessionManager_A08 {

    public static void main(String[] args) {
        Path path = Paths.get("path_to_file");
        SessionManager sessionManager = new SessionManager(path);
        sessionManager.manageSession();
    }

    private Path filePath;
    private FileChannel fileChannel;

    public java_27466_SessionManager_A08(Path path) {
        this.filePath = path;
    }

    public void manageSession() {
        try {
            fileChannel = FileChannel.open(filePath);
            fileChannel.write(ByteBuffer.wrap("Hello World".getBytes()));
            System.out.println("Data written to file successfully.");

            ByteBuffer buffer = ByteBuffer.allocate(10);
            fileChannel.read(buffer);
            String readData = new String(buffer.array(), 0, buffer.position());
            System.out.println("Data read from file: " + readData);

            fileChannel.close();
            System.out.println("File channel closed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}