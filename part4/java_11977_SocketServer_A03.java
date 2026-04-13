import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11977_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket socket = server.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_11977_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Simulate security-sensitive operation related to A03_Injection
            String response = processMessage(message);

            out.writeUTF(response);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processMessage(String message) {
        // This is a placeholder for a security-sensitive operation
        // It is used to demonstrate the concept of A03_Injection
        return "Processed: " + message;
    }
}