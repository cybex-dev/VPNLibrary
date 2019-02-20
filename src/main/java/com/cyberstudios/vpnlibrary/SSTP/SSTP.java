package com.cyberstudios.vpnlibrary.SSTP;

/**
 * Encapsulates the logic used for MS-SSTP communication
 * <p>
 * Breakdown of MS-SSTP communication
 *
 * <b>Establish Connection</b>
 * <ol>
 * <li>Create SSL connection to remote server</li>
 * <li>Send HTTP request over SSL connect with Method call "HTTP_DUPLEX_POST" and Content-Length: ULONGLONG_MAX</li>
 * <li>Server Responds with "HTTP_STATUS_OK" and Content-Length: ULONGLONG_MAX</li>
 * <li>Start SSTP Call Connect Request</li>
 * <li>Server acknowledges SSTP Call Connect Request</li>
 * <li>Tunnel Established</li>
 * </ol>
 *
 * <b>Teardown Connection</b>
 * <ol>
 * <li>Client sends Call Disconnect Request</li>
 * <li>Server acknowledges call disconnect request</li>
 * <li>Tunnel torn down</li>
 * </ol>
 */
public class SSTP {


    // VERSION 16 in binary is  0001 0000
    // this resembles SSTP (v)     1.   0
    public static final byte VERSION = 16;

    /**
     * Used in SSTP Control Packet to define the Control Packet purpose (message)
     */
    public static class Message {
        /**
         * This is the command that is first send to the SSTP server after a (HTTP with SSL) connection is established.
         * This command requests an SSTP connection be established to the server.
         */
        public static final short SSTP_MSG_CALL_CONNECT_REQUEST = 0x0001;

        /**
         * This command is returned from the server upon a successful connection request is acknowledged.
         */
        public static final short SSTP_MSG_CALL_CONNECT_ACK = 0x0002;

        /**
         * If the connection request is unsuccessful, this command is returned from the server.
         */
        public static final short SSTP_MSG_CALL_CONNECT_NAK = 0x0003;

        /**
         * This command is sent from the client to the server after:
         * <ul>
         * <li>a successful PPP authentication has been established with the server</li>
         * <li>uppon a successful HTTP (with SSL) connection has been established with the serverp</li>
         * </ul>
         */
        public static final short SSTP_MSG_CALL_CONNECTED = 0x0004;

        /**
         * This command is sent from the server to the connecting/connected client, to abnormally close the SSTP tunnel.
         * This command can be found e.g. in the case of an abnormal/inconsistent packet length
         */
        public static final short SSTP_MSG_CALL_ABORT = 0x0005;

        /**
         * This command is sent to the SSTP server to initiate a normal disconnect procedure.
         */
        public static final short SSTP_MSG_CALL_DISCONNECT = 0x0006;

        /**
         * This command can be sent from the SSTP server or client in response to a SSTP_MSG_CALL_DISCONNECT command.
         */
        public static final short SSTP_MSG_CALL_DISCONNECT_ACK = 0x0007;

        /**
         * This command is sent to a SSTP server or to a client in the case of an SSTP control or data packet not being received in an allocated amount of time.
         */
        public static final short SSTP_MSG_ECHO_REQUEST = 0x0008;

        /**
         * This command is sent to a SSTP server or to a client in response to the SSTP_MSG_ECHO_REQUEST.
         */
        public static final short SSTP_MSG_ECHO_RESPONSE = 0x0009;
    }

    /**
     * Attribute types used in main SSTP Attribute Packet
     */
    public static class Attributes {
        public static final byte SSTP_ATTRIB_ENCAPSULATED_PROTOCOL_ID = 0x01;
        public static final byte SSTP_ATTRIB_STATUS_INFO = 0x02;
        public static final byte SSTP_ATTRIB_CRYPTO_BINDING = 0x03;
        public static final byte SSTP_ATTRIB_CRYPTO_BINDING_REQ = 0x04;
    }

    /**
     * Used in defining the Hash Protocol Bitmask and referencing a Hash Protocol to use.
     */
    public static class CertificateHashProtocolConstants {
        public static final byte CERT_HASH_PROTOCOL_SHA1 = 1;
        public static final byte CERT_HASH_PROTOCOL_SHA256 = 2;
        public static final byte CERT_HASH_PROTOCOL_ALL = 3;

    }

    /**
     * Used in:
     * <ul>
     * <li>Status Attribute Packet</li>
     * <li>Call Connect Negative Acknowledgment Message</li>
     * <li>Call Disconnect Message</li>
     * </ul>
     * as AttribID
     */
    public static class StatusAttribute {
        public static final byte SSTP_ATTRIB_NO_ERROR = 0x00;
        public static final byte SSTP_ATTRIB_ENCAPSULATED_PROTOCOL_ID = 0x01;
        public static final byte SSTP_ATTRIB_STATUS_INFO = 0x02;
        public static final byte SSTP_ATTRIB_CRYPTO_BINDING = 0x03;
        public static final byte SSTP_ATTRIB_CRYPTO_BINDING_REQ = 0x04;
    }

    /**
     * Used in:
     * <ul>
     * <li>Status Attribute Packet</li>
     * <li>Call Connect Negative Acknowledgment Message</li>
     * <li>Call Disconnect Message</li>
     * </ul>
     * to gain insight on the event
     */
    public static class StatusMessage {
        public static final int ATTRIB_STATUS_NO_ERROR = 0x00000000;
        public static final int ATTRIB_STATUS_DUPLICATE_ATTRIBUTE = 0x00000001;
        public static final int ATTRIB_STATUS_UNRECOGNIZED_ATTRIBUTE = 0x0000002;
        public static final int ATTRIB_STATUS_INVALID_ATTRIB_VALUE_LENGTH = 0x00000003;
        public static final int ATTRIB_STATUS_VALUE_NOT_SUPPORTED = 0x00000004;
        public static final int ATTRIB_STATUS_UNACCEPTED_FRAME_RECEIVED = 0x00000005;
        public static final int ATTRIB_STATUS_RETRY_COUNT_EXCEEDED = 0x00000006;
        public static final int ATTRIB_STATUS_INVALID_FRAME_RECEIVED = 0x00000007;
        public static final int ATTRIB_STATUS_NEGOTIATION_TIMEOUT = 0x00000008;
        public static final int ATTRIB_STATUS_ATTRIB_NOT_SUPPORTED_IN_MSG = 0x00000009;
        public static final int ATTRIB_STATUS_REQUIRED_ATTRIBUTE_MISSING = 0x0000000a;
    }

    public static class Encapsulation {
        public static final  short SSTP_ENCAPSULATED_PROTOCOL_PPP = 0x0001;
    }

    // Use variable sizeOf (int, short, etc)
    // Add items to SSTPPacketBuilder and convert to byte chunks
    public void sendAttribute_EncapsulatedProtocolIDAttribute() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder(2);
        packet.withEncapsulatedProtocolAttribute();
        packet.build();
    }

    public void sendAttribute_CryptoBindingRequestAttribute() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendAttribute_CryptoBindingAttribute() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendAtribute_StatusInfoAttribute() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallConnectRequestMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallConnectAcknowledgeMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallConnectedMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallConnectNegativeAcknowledgmentMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallAbortMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallDisconnectMessage() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendMessage_CallDisconnectAcknowledge() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendEchoRequest() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }

    public void sendEchoResponse() {
        SSTPPacket.Builder packet = new SSTPPacket.Builder();
    }
}
