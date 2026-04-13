import java.io.*;
import java.net.*;

public class java_23172_SocketServer_A03 {
    private static final int port = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = server.accept()) {
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                    String message = input.readUTF();
                    System.out.println("Client says: " + message);

                    // This is a very simple way to check for injection attacks.
                    // In a real-world application, you would need to use a more sophisticated
                    // method of checking for injection attacks, possibly involving the execution
                    // of the client's code and the server's code in a sandboxed environment.
                    if (message.contains("injection")) {
                        System.out.println("Injection attempt detected!");
                        output.writeUTF("Injection attempt detected!");
                    } else {
                        String response = "Hello, client!";
                        output.writeUTF(response);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}