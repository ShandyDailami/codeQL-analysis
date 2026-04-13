import java.io.*;
import java.net.*;
import java.util.*;

public class java_28812_SocketServer_A07 {

    private static int port = 12345;
    private static ServerSocket server;

    public static void main(String[] args) throws Exception {
        server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            handleClient(socket);
        }
    }

    public static void handleClient(Socket socket) {
        PrintWriter out = null;
        DataInputStream in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new DataInputStream(socket.getInputStream());
            String clientMessage = in.readUTF();
            String response = "Message from client: " + clientMessage +
                    ". Served from: " + socket.getInetAddress().getHostAddress() +
                    ". Random Number: " + new Random().nextInt();
            out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}