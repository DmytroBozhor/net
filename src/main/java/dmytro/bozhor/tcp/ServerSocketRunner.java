package dmytro.bozhor.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketRunner {

    public static void main(String[] args) throws IOException {

        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var request = new DataInputStream(socket.getInputStream());
             var response = new DataOutputStream(socket.getOutputStream())) {

            var clientMessage = request.readUTF();
            System.out.println("Message from client: " + clientMessage);
            response.writeUTF("Server successfully got the message from client.");
        }

    }
}
