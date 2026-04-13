import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35135_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private final Socket socket;

    public java_35135_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new data input stream
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Read the client's message
            String message = in.readUTF();

            // The client's message should contain a command and a payload
            // For example: "REGISTER name:user,password:pass"
            String[] parts = message.split(":");

            // The payload is the part after the command
            String payload = parts[1];

            // Perform security-sensitive operations related to injection
            // For example, remove the payload string from a SQL query
            // This is a very simplistic example and does not actually perform any security-sensitive operations
            if (payload.contains(";") || payload.contains("--")) {
                payload = payload.replace(";", "");
                payload = payload.replace("--", "");
            }

            // Send back a response
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("OK: " + payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}