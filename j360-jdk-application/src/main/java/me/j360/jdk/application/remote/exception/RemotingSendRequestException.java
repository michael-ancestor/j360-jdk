package me.j360.jdk.application.remote.exception;

/**
 * RPC�����У��ͻ��˷�������ʧ�ܣ��׳����쳣
 */
public class RemotingSendRequestException extends RemotingException {
    private static final long serialVersionUID = 5391285827332471674L;


    public RemotingSendRequestException(String addr) {
        this(addr, null);
    }


    public RemotingSendRequestException(String addr, Throwable cause) {
        super("send request to <" + addr + "> failed", cause);
    }
}