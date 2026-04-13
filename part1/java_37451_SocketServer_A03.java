import java.net.*;
import java.io.*;

public class java_37451_SocketServer_A03 {

    public static void main(String args[]) {
        ServerSocket server = null;
        while (true) {
            try {
                server = new ServerSocket(8000); // port number
                System.out.println("Waiting for client connection...");
                Socket socket = server.accept(); // accept connection from client
                System.out.println("Connected to client");

                // Create streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Handle communication
                String clientInput = dis.readUTF(); // read from client
                System.out.println("Received: " + clientInput);
                String serverOutput = "Hello client"; // handle the data
                dos.writeUTF(serverOutput); // write to client
                dos.flush();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}