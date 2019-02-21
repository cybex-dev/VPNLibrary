package com.cyberstudios.vpnlibrary.SSTP;

import com.cyberstudios.vpnlibrary.interfaces.PacketBuilder;

public class SSTPPacket {

    private SSTPPacket() {
    }

    public enum PacketType {
        Control(1),
        Data(0);

        byte type = 0;

        PacketType(int i) {
            this.type = (byte) i;
        }
    }

    public static class Builder implements PacketBuilder<SSTPPacket> {
        private PacketType packetType;
        private short encapsulationProtocolID;
        private SSTPPacketHeader packetHeader = new SSTPPacketHeader();
        private ByteChunk data;

        public Builder(int packetDataByteSize) {
            data = new ByteChunk(packetDataByteSize);
        }

        public Builder setPacketType(PacketType control) {
            this.packetType = control;
            return this;
        }

        @Override
        public SSTPPacket build() {
            if (data.getByteSize() + packetHeader.getBytes().getByteSize() > SSTP.MAX_PACKET_SIZE) {
                // This cannot be the case, since the number of bits allowed for specifying the packet size is not enough to accommodate more data.
                return null;
            }

            packetHeader.setPacketType(packetType);
            packetHeader.setDataLength(data.getByteSize());
            return null;
        }

        public Builder addBytes(short byteData) {
            data.addBytes(byteData, 0);
            return this;
        }

        public Builder addBytes(int index, short byteData) {
            data.addBytes(byteData, index);
            return this;
        }

        public Builder addBytes(byte byteData) {
            data.addBytes(byteData, 0);
            return this;
        }

        public Builder addBytes(int index, byte byteData) {
            data.addBytes(byteData, index);
            return this;
        }

        public Builder addBytes(int byteData) {
            data.addBytes(byteData, 0);
            return this;
        }

        public Builder addBytes(int index, int byteData) {
            data.addBytes(byteData, index);
            return this;
        }
    }
}
