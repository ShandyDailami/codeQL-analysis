import java.io.*;
import java.net.*;

public class java_24362_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(65000);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Connected to client");

        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

        String data;

        while ((data = dataIn.readUTF()) != null) {
            System.out.println("Received: " + data);
            dataOut.writeUTF("Server: " + data);
            dataOut.flush();
       
            if (data.equals("exit")) {
                socket.close();
                server.close();
            }
        }
    }
}