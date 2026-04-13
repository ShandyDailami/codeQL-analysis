import java.io.*;
import java.net.*;

public class java_09387_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started at port 4444");
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                
                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataIn.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello, Client";
                dataOut.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}