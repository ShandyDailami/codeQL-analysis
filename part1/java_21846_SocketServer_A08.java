import java.io.*;
import java.net.*;

public class java_21846_SocketServer_A08 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;
        try {
            server = new ServerSocket(1234); // listening on port 1234
            System.out.println("Waiting for a client...");
            socket = server.accept();
            System.out.println("Client accepted");
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage;
            while ((clientMessage = inFromClient.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                outToClient.writeBytes(clientMessage + "\n");
           
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}