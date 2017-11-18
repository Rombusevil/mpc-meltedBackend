package meltedBackend.common;

import meltedBackend.statuscmd.StatusCmdProcessor;

/**
 * 
 * @author rombus
 */
public interface MeltedClient {
    String send(String cmd, long timeout) throws MeltedCommandException;
    String send(String cmd) throws MeltedCommandException;
    void listenStatus(StatusCmdProcessor sp) throws MeltedCommandException;
}
