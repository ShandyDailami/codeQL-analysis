import java.io.*;
import java.net.*;

public class java_26613_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started at port 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String clientMessage = input.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                if (clientMessage.equals("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                String serverMessage = "Hello, client!";
                output.writeUTF(serverMessage);

                output.flush();
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}