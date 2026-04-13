import java.io.*;
import java.net.*;

public class java_22230_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started at port 8189");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                DataInputStream dataIn = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataIn.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Server received: " + clientMessage;
                dataOut.writeUTF(serverMessage);
                dataOut.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}