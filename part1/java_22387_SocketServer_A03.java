import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22387_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000); // port number
            System.out.println("Server started on port 8000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientInput;
                while ((clientInput = in.readLine()) != null) {
                    System.out.println("Received: " + clientInput);
                    out.println("Server received: " + clientInput);
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}