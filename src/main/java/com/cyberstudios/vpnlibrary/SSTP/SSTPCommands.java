package com.cyberstudios.vpnlibrary.SSTP;

/**
 * Defines the commands used during the communication between the SSTP server and client as outlined in the MS-SSTP protocol
 */
public class SSTPCommands {

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
     *     <li>a successful PPP authentication has been established with the server</li>
     *     <li>uppon a successful HTTP (with SSL) connection has been established with the serverp</li>
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
