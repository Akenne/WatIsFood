package ca.waterloo.watisfood;

import java.util.List;

/**
 * Created by Kevin on 20/09/2014.
 */
public class BuildingLocation {
    public int[] locate(String buildingCode) {
        if (buildingCode.equals("DC")) {
            return new int[]{1480, 655};
        } else if (buildingCode.equals("OPT")){
            return new int[]{1368, 54};
        } else if (buildingCode.equals("BMH")){
            return new int[]{1274, 356};
        } else if (buildingCode.equals("UC")){
            return new int[]{978, 427};
        } else if (buildingCode.equals("V1")){
            return new int[]{662, 425};
        } else if (buildingCode.equals("REV")){
            return new int[]{157, 450};
        } else if (buildingCode.equals("SLC")){
            return new int[]{1119, 637};
        } else if (buildingCode.equals("EIT")){
            return new int[]{1430, 819};
        } else if (buildingCode.equals("NH")){
            return new int[]{1140, 993};
        } else if (buildingCode.equals("DP")){ // LIB on map
            return new int[]{1287, 1016};
        } else if (buildingCode.equals("ML")){
            return new int[]{1207, 1073};
        } else if (buildingCode.equals("SCH")){
            return new int[]{1416, 1164};
        } else if (buildingCode.equals("HH")){
            return new int[]{1238, 1314};
        } else if (buildingCode.equals("EV3")){
            return new int[]{1082, 1172};
        } else if (buildingCode.equals("PAS")){
            return new int[]{1095, 1393};
        } else {
            return new int[]{0, 0};
        }

    }
    public static int[][] coords = {{1480, 655},{1368, 54},{1274, 356},{978, 427},{662, 425},{157, 450},{1119, 637},{1430, 819},
            {1140, 993},{1287, 1016},{1207, 1073},{1416, 1164},{1238, 1314},{1082, 1172},{1095, 1393}};
    public static String[] buildingCodes = {"DC","OPT","BMH","UC","V1","REV","SLC","EIT","NH","DP","ML","SCH","HH","EV3","PAS"};
}
