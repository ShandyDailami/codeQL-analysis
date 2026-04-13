import java.io.*;
import java.net.*;

public class java_32325_SocketServer_A08 {
    private static final String MESSAGE = "Hello World";
    private static final int PORT = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                String serverMessage = XORCipher(clientMessage);
                out.println(serverMessage);
            }
            socket.close();
        }
    }

    private static String XORCipher(String data) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= 'T';
        }
        return new String(chars);
    }
}