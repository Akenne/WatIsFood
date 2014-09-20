package ca.waterloo.watisfood;

/**
 * Created by Kevin on 20/09/2014.
 */
public class BuildingLocation {
    public int[] locate(String buildingCode) {
        if (buildingCode.equals("DC")) {
            return new int[]{1484, 671};
        } else if (buildingCode.equals("OPT")){
            return new int[]{1370, 68};
        } else if (buildingCode.equals("BMH")){
            return new int[]{1276, 369};
        } else if (buildingCode.equals("UC")){
            return new int[]{928, 445};
        } else if (buildingCode.equals("V1")){
            return new int[]{666, 443};
        } else if (buildingCode.equals("REV")){
            return new int[]{162, 464};
        } else if (buildingCode.equals("SLC")){
            return new int[]{1125, 656};
        } else if (buildingCode.equals("EIT")){
            return new int[]{1484, 671};
        } else if (buildingCode.equals("NH")){
            return new int[]{1437, 837};
        } else if (buildingCode.equals("LIB")){
            return new int[]{1290, 1031};
        } else if (buildingCode.equals("ML")){
            return new int[]{1484, 671};
        } else if (buildingCode.equals("TC")){
            return new int[]{1212, 1090};
        } else if (buildingCode.equals("SCH")){
            return new int[]{1418, 1178};
        } else if (buildingCode.equals("HH")){
            return new int[]{1241, 1329};
        } else if (buildingCode.equals("EV3")){
            return new int[]{1085, 1139};
        } else if (buildingCode.equals("PAS")){
            return new int[]{1110, 1410};
        }
        return null;
    }
}