package Storm;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import com.opencsv.*;

/**
 * Created by matt on 12/3/16.
 */
public class ReadFiles {
    public ReadFiles() throws IOException {

    }


    public Hashtable<String, Storm> createHashTable() throws IOException {

        ArrayList<String[]> temparrayList = new ArrayList<String[]>();
        Hashtable<String, Storm> stormtable = new Hashtable<String, Storm>();
        for (int k = 1945; k < 2016; k++) {
            if (k != 1989) {
                //Reads in data, removes spaces, and creates arraylist and hashtable for storage
                CSVReader reader = new CSVReader(new FileReader((k + ".csv")));
                List<String[]> data = reader.readAll();
                removeSpaces(data);
                String currentStormID = data.get(0)[0];
                String currentYear = data.get(0)[1].substring(0, 4);
                for (int i = 0; i < data.size(); i++) {
                    String stormID = data.get(i)[0];
                    if (currentStormID.equals(stormID)) {
                        temparrayList.add(data.get(i));
                    } else {
                        String primaryKey = currentYear + currentStormID;
                        Storm storm = new Storm(temparrayList);
                        stormtable.put(primaryKey, storm);
                        temparrayList = new ArrayList<String[]>();
                        temparrayList.add(data.get(i));
                        currentStormID = data.get(i)[0];
                        currentYear = data.get(i)[1].substring(0, 4);
                    }

                }
            }
        }
        return stormtable;

    }



    public static void removeSpaces(List<String[]> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < 4; j++) {
                data.get(i)[j] = data.get(i)[j].replaceAll("\\s+", "");
            }
        }

    }

}
