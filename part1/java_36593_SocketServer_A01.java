import java.io.*;
import java.net.*;

public class java_36593_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for client on port " + server.getLocalPort());

            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

            String message;

            while ((message = inputFromClient.readUTF()) != null) {
                System.out.println("Received from client: " + message);

                if (message.equals("exit")) {
                    socket.close();
                    server.close();
                } else {
                    outputToClient.writeUTF("Thank you for connecting to server. Your message has been received.");
                }

                outputToClient.flush();
           .
.
.
.
                // rest of the code
                .
.
.
.
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}