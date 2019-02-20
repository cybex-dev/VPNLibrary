package com.cyberstudios.vpnlibrary.SSTP;

/**
 * Simulates a byte/bit array where {@link java.lang.Integer}s, {@link java.lang.Short}s, {@link java.lang.Byte}s are added as bytes into a byte array.
 * Adding the various data types to the byte array is used using Big Endian order, where the most significant bits are added to the lowest memory address (first address) and the lowest or least significant value is added to the highest memory address.
 *
 * This implementation respects Network Byte Order using Big Endian Order.
 *
 * @author Charles Dyason
 */
public class ByteChunk {
    private byte[] chunk;
    private int length = 0;

    public ByteChunk(int byteSize) {
        chunk = new byte[byteSize];
    }

    public void addByte(byte b, int offset){
        if (!hasSpace(1)) {
            return;
        }

        // Add byte
        chunk[length++] = b;
    }

    public void addBytes(int i, int offset){
        // Check if offset + 4 bytes can fit into ByteChuck
        if (!hasSpace(4)) {
            return;
        }

        // Add byte chunks using Big Endian (for Network Byte Order)
        chunk[length++] = (byte)((i>>24)&0xFF);
        chunk[length++] = (byte)((i>>16)&0xFF);
        chunk[length++] = (byte)((i>>8)&0xFF);
        chunk[length++] = (byte)(i&0xFF);
    }

    public void addBytes(short s, int offset){
        // Check if offset + 4 bytes can fit into ByteChuck
        if (!hasSpace(2)) {
            return;
        }

        // Add byte chunks using Big Endian (for Network Byte Order)
        chunk[length++] = (byte)((s>>8)&0xFF);
        chunk[length++] = (byte)(s&0xFF);
    }

    public boolean isFull(){
        return chunk.length == length + 1;
    }

    public boolean hasSpace(int byteSizeRequired){
        return (chunk.length - 1) > (length + byteSizeRequired);
    }

    public boolean isEmpty(){
        return length == 0;
    }
}