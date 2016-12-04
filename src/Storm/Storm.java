package Storm;

import java.util.ArrayList;

/**
 * Created by matt on 11/23/16.
 */
public class Storm {
    private ArrayList<String[]> stormTracks;
    private String startDate;
    private String endDate;
    private String stormID;

    public Storm(ArrayList<String[]> stormTracks ){
        this.stormTracks = stormTracks;
        startDate = stormTracks.get(0)[1];
        stormID = stormTracks.get(0)[0];
        endDate = stormTracks.get(stormTracks.size() -1)[0];

    }
    public String getStartDate(){
        return startDate;
    }
    public String getEndDate(){
        return endDate;
    }
    public String getStormID(){
        return stormID;
    }
    public String getDate(int index){
        return stormTracks.get(index)[1];
    }
    public String getLatitude(int index){
        return stormTracks.get(index)[2];
    }
    public String getLongitude(int index){
        return stormTracks.get(index)[3];
    }
    public int getLength(){
        return stormTracks.size();
    }


}
