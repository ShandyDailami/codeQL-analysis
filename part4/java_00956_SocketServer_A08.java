import java.net.*;
import java.io.*;

public class java_00956_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 3333;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

                OutputStream out = new BufferedOutputStream(socket.getOutputStream());
                DataOutputStream outToClient = new DataOutputStream(out);

                InputStream in = new BufferedInputStream(socket.getInputStream());
                DataInputStream inFromClient = new DataInputStream(in);

                String clientMessage = inFromClient.readUTF();
                System.out.println("Client message: " + clientMessage);

                String responseMessage;
                if (clientMessage.equals("Hello")) {
                    responseMessage = "Hello, client!";
                } else {
                    responseMessage = "Invalid message, client!";
                }

                outToClient.writeUTF(responseMessage);
                outToClient.flush();
                System.out.println("Server response: " + responseMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}