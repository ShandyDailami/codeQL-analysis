import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class java_10267_SocketServer_A07 {
    private static final String SERVER_LOOP_CONTINUE = "y";
    private static final String SERVER_LOOP_STOP = "n";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if ("quit".equals(message)) {
                        socket.close();
                        System.out.println("Connection closed");
                        break;
                    }

                    outputStream.write(("Server: " + message + "\n").getBytes());
                    outputStream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}