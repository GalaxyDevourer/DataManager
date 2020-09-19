package chmnu.project.csv.manager;

import chmnu.project.config.SettingsManager;
import chmnu.project.csv.tables.ConvertedTable;
import chmnu.project.csv.tables.InitialTable;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomCSVManager {
    private HashMap<String, String> statesMap = new SettingsManager().getMapRegions();

    public CustomCSVManager() throws IOException {
    }

    public List<ConvertedTable> convertTables (List<InitialTable> initialTableList) {
        List<ConvertedTable> convertedTableList = new LinkedList<>();

        initialTableList.forEach( x -> {
            convertedTableList.add(new ConvertedTable(x.getProvince_State(), getKeyFromValue(statesMap, x.getCountry_Region()), x.getConfirmed(), x.getDeaths(), x.getRecovered(), x.getActive(), x.getIncident_Rate()));
        });

        return convertedTableList;
    }

    private static String getKeyFromValue(Map<String, String> hm, String value) {
        for (String o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

}
