import java.io.*;
import java.net.*;

public class java_04022_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 6666;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("A08_IntegrityFailure")) {
                    // If the message is "A08_IntegrityFailure", simulate a failure
                    output.writeUTF("Failure");
                    output.flush();
                    System.out.println("Simulated A08_IntegrityFailure");
                } else {
                    // If the message is not "A08_IntegrityFailure", write it back to the client
                    output.writeUTF(message);
                    output.flush();
                    System.out.println("Written: " + message);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}