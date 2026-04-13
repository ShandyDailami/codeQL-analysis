import java.io.*;
import java.net.*;

public class java_35008_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345); // open a port on which server listens
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = server.accept(); // accept client
                System.out.println("New client connected");

                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

                // read from client
                String clientMessage = dataIn.readUTF();
                System.out.println("Client says: " + clientMessage);

                // send a response back to client
                String serverMessage = "Server says: Hello " + clientMessage;
                dataOut.writeUTF(serverMessage);

                // close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}