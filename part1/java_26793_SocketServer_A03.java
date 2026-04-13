import java.net.*;
import java.io.*;

public class java_26793_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected!");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received message: " + message);
                // Check for SQL injection or other injection attack
                if (message.contains(";") || message.contains("'") || message.contains("--") || message.contains("/*")) {
                    System.out.println("Suspicious activity detected!");
                    out.writeBytes("Suspicious activity detected! \n");
                } else {
                    out.writeBytes(message + "\n");
                }
            }

            socket.close();
        }
    }
}