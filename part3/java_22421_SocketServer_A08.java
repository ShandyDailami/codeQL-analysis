import java.io.*;
import java.net.*;

public class java_22421_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Start response
            dataOutputStream.writeBytes("HTTP/1.1 200 OK\r\n");
            dataOutputStream.writeBytes("Content-Type: text/html; charset=utf-8\r\n");
            dataOutputStream.writeBytes("\r\n");

            // Get request
            String requestLine = dataInputStream.readLine();
            System.out.println(requestLine);

            // Authentication
            String auth = dataInputStream.readLine();
            if ("Authorization: Basic ".equals(auth)) {
                byte[] credentialsBytes = dataInputStream.readBytes(dataInputStream.read());
                String credentials = new String(credentialsBytes, "UTF-8");
                String[] credentialsArray = credentials.split(":");
                if ("username".equals(credentialsArray[0]) && "password".equals(credentialsArray[1])) {
                    dataOutputStream.writeBytes("Authorization: Basic QWxhZGR.....");
                    dataOutputStream.writeBytes("\r\n");
                } else {
                    dataOutputStream.writeBytes("Authorization: Basic ERROR\r\n");
                    dataOutputStream.writeBytes("\r\n");
                }
            } else {
                dataOutputStream.writeBytes("WWW-Authenticate: Basic realm=\"Restricted Area\"\r\n");
                dataOutputStream.writeBytes("\r\n");
            }

            dataOutputStream.flush();
        }
    }
}