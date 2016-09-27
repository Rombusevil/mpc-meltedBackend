package meltedBackend.responseParser.responses;

import meltedBackend.common.MeltedCommandException;
import java.util.ArrayList;

/**
 * Generic Response class for storing Melted command's responses.
 * Use this class with StatusParser.
 * 
 * @author rombus
 */
public class GenericResponse {
    protected String status;           // Status string
    protected String[] singleData;     // Array of data for commands with one line responses (aside from status line)
    protected ArrayList<String[]> data;// ArrayList of data for commands with multi line responses (aside from status line)

    public GenericResponse setData(String status, String[] singleData, ArrayList<String[]> data){
        this.status = status;
        this.singleData = singleData;
        this.data = data;
        
        return this;
    }

    /**
     * Simlpe way of checking if the command was successful.
     *
     * @return true if the command was OK, false otherwise.
     * @throws meltedBackend.common.MeltedCommandException
     */
    public boolean cmdOk() throws MeltedCommandException{
        try{
            return status.split(" ")[1].equals("OK");
        }
        catch(Exception e){
            throw new MeltedCommandException("`GenericResponse` - Cannot get status data.");
        }
    }

    public String getStatus(){
        return status;
    }
}