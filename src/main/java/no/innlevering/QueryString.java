package no.innlevering;

import javax.lang.model.util.Types;
import java.util.HashMap;

public class QueryString {

    private static String queryString;

    public QueryString(String queryString) {
        this.queryString = queryString;
    }

    public static String getParameter(String parameterName) {
        HashMap<String, String> convertedQuery = new HashMap<>();
        if (!queryString.contains("&")) {
            int equalsPos1 = queryString.indexOf("=");
            String firstParameterName1 = queryString.substring(0, equalsPos1);
            String firstParameterValue1 = queryString.substring(equalsPos1 +1);
            convertedQuery.put(firstParameterName1, firstParameterValue1);
        } else if (queryString.contains("&")) {
            int splitInt = queryString.indexOf("&");

            String firstPart = queryString.substring(0, splitInt);
            String secondPart = queryString.substring(splitInt + 1);

            int equalsPos = firstPart.indexOf("=");
            int equalsPos2 = secondPart.indexOf("=");

            String firstParameterName = firstPart.substring(0, equalsPos);
            String firstParameterValue = firstPart.substring(equalsPos + 1);

            String secondParameterName = secondPart.substring(0, equalsPos2);
            String secondParameterValue = secondPart.substring(equalsPos2 + 1);

            convertedQuery.put(firstParameterName, firstParameterValue);
            convertedQuery.put(secondParameterName, secondParameterValue);
        }

        String parameterValue = "";
        if (convertedQuery.containsKey(parameterName)) {
            parameterValue = convertedQuery.get(parameterName);
            return parameterValue;
        }


        return "-1";
    }
}
