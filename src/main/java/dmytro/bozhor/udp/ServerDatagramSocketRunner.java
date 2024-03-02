package dmytro.bozhor.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDatagramSocketRunner {

    public static void main(String[] args) throws IOException {
        var buffer = new byte[512];
        try (var datagramSocket = new DatagramSocket(7777)) {
            var datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData()));
        }
    }
}
