import java.io.*;
import java.net.*;

public class java_35775_SocketServer_A08 {
    private static int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new client " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // read message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // send message back to the client
                String response = "Hello, client, your message is: " + message;
                out.writeUTF(response);
                System.out.println("Sent: " + response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}