import java.io.*;
import java.net.*;

public class java_19981_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // get input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // send response
            out.writeUTF("HTTP/1.1 200 OK\r\n\r\n" + request);
            out.flush();

            socket.close();
        }
    }
}