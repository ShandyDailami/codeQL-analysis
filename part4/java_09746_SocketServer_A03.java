import java.io.*;
import java.net.*;

public class java_09746_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4446); // port number
            while(true) {
                Socket socket = server.accept();

                // wrap the socket in a DataInputStream for reading
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                // read the message from the client
                String message = dis.readUTF();
                System.out.println("Client says: " + message);

                // now we'll write back a response
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String response = "Hello, client!";
                dos.writeUTF(response);

                // close the socket connection
                socket.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}