package no.innlevering;

import java.util.HashMap;

public class QueryString {


    public static String getParameter(String parameterName, String testQuery) {
        HashMap<String, String> convertedQuery = new HashMap<>();
        int splitInt = testQuery.indexOf("&");
        String firstPart = testQuery.substring(0,splitInt);
        String secondPart = testQuery.substring(splitInt+1);
        int equalsPos = firstPart.indexOf("=");
        convertedQuery.put(firstPart.substring());

        String statusValue = "";
        if (parameterName == "status") {
            int indexOfEqual = testQuery.indexOf("=");
            statusValue = testQuery.substring(indexOfEqual + 1);
        }
            return convertedQuery.get(parameterName);

    }
}
