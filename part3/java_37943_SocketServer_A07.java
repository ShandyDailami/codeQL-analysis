import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37943_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMessage = reader.readLine();
            System.out.println("Received message: " + clientMessage);

            if (clientMessage.equals("auth_fail")) {
                outputStream.write("fail\n".getBytes());
            } else {
                outputStream.write("success\n".getBytes());
            }

            outputStream.flush();
            socket.close();
        }
    }
}