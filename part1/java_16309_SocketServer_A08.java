import java.io.*;
import java.net.*;

public class java_16309_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client is connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            dos.writeUTF("Thank you for connecting to the server");
            socket.close();
       
        }

    }
}