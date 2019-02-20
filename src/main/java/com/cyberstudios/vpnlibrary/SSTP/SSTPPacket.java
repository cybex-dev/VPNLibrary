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
        private ByteChunk byteChunk;

        public Builder(int packetDataByteSize) {
            byteChunk = new ByteChunk(SSTPPacketHeader.BYTE_SIZE + packetDataByteSize);
        }

        public Builder setPacketType(PacketType control) {
            this.packetType = control;
            return this;
        }

        public Builder withMessage() {
            return this;
        }

        public Builder withEncapsulatedProtocolAttribute() {

            return this;
        }

        @Override
        public SSTPPacket build() {
            packetHeader.setPacketType(packetType);
        }
    }
}
