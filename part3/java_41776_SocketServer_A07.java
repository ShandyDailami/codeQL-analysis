import java.io.*;
import java.net.*;

public class java_41776_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            if (isAuthorized(request)) {
                dos.writeUTF("Success");
                dos.flush();
            } else {
                dos.writeUTF("Failed");
                dos.flush();
           
                socket.close();
            }
        }
    }

    // Simplified authentication mechanism. Real-world applications would need more robust security measures.
    private static boolean isAuthorized(String request) {
        // This is a simplistic approach to authentication. In a real-world scenario, you would need to decode the request and compare it to some predefined credentials.
        return request.equals("A07_AuthFailure");
    }
}