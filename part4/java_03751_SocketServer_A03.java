import java.io.*;
import java.net.*;

public class java_03751_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String data = dis.readUTF();
        System.out.println("Received: " + data);

        String manipulatedData = manipulateData(data);
        dos.writeUTF(manipulatedData);
        dos.flush();

        socket.close();
    }

    private static String manipulateData(String data) {
        // This is a very simple example of an SQL injection.
        // A real application would use a more secure method to build SQL queries.
        return "SELECT * FROM Users WHERE username = '" + data + "' AND password = '" + data + "'";
    }
}