import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_28073_SocketServer_A08 {
    private final static int PORT = 8080;
    private final static int NTHREAD = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREAD);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();
                executor.execute(new SocketTask(input, output, socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class SocketTask implements Runnable {
    private InputStream input;
    private OutputStream output;
    private Socket socket;

    public java_28073_SocketServer_A08(InputStream input, OutputStream output, Socket socket) {
        this.input = input;
        this.output = output;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];
            int length;
            while ((length = input.read(bytes)) != -1) {
                byte[] decryptedBytes = decrypt(bytes, length);
                output.write(decryptedBytes);
            }
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private byte[] decrypt(byte[] bytes, int length) {
        // Your decryption logic here
        // For simplicity, we are returning the same bytes for simplicity
        return bytes;
    }
}