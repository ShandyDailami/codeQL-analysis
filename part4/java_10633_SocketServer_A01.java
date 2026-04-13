import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class java_10633_SocketServer_A01 {
    private ServerSocket serverSocket;

    public java_10633_SocketServer_A01(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                InputStreamReader input = new InputStreamReader(inputStream);

                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println("Received: " + line);

                    if ("exit".equals(line)) {
                        outputStream.write("Server exiting...\n".getBytes());
                        socket.close();
                        break;
                    } else {
                        outputStream.write("Server received the message\n".getBytes());
                    }
                    outputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        SocketServer server = new SocketServer(port);

        try {
            Method method = ServerSocket.class.getDeclaredMethod("setPermittedRequestCount", int.class);
            method.setAccessible(true);
            method.invoke(server.serverSocket, Integer.MAX_VALUE);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        server.startServer();
    }
}