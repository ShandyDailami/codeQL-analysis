import java.io.*;
import java.net.*;

public class java_19599_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189); // port number

        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept(); // blocking call

            System.out.println("Client connected " + socket.getRemoteSocketAddress());

            // create the streams for reading and writing
            OutputStream out = new BufferedOutputStream(socket.getOutputStream());
            InputStream in = new BufferedInputStream(socket.getInputStream());

            // read from the client and write back to the client
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Server says: " + clientMessage;
            dos.writeUTF(serverMessage);
            dos.flush();

            socket.close();
        }
    }
}