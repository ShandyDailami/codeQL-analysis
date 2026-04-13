import java.io.*;
import java.net.*;

public class java_01337_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // create input stream and output stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // read data from client
            String clientMsg = dis.readUTF();

            // echo back client's message
            dos.writeUTF("Server echo: " + clientMsg);

            // close streams and socket
            dos.close();
            dis.close();
            socket.close();
        }
    }
}