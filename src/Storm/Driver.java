package Storm;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by matt on 12/2/16.
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        ReadFiles readfiles = new ReadFiles();
        Hashtable<String, Storm> stormHashtable = readfiles.createHashTable();
        //Objects are stored by year + stormID
        Storm testStorm = stormHashtable.get("194501");
        //Zero is the first storm track entry to get
        System.out.println(testStorm.getLatitude(0) + " " + testStorm.getLongitude(0));
        String longitude = testStorm.getLongitude(0);






    }
}
