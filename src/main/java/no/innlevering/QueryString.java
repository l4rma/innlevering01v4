package no.innlevering;

import java.util.HashMap;

public class QueryString {

    public String queryString = "";

    public QueryString(String queryString) {
        this.queryString = queryString;
    }

    public static String getParameter(String parameterName, String testQuery) {
        HashMap<String, String> convertedQuery = new HashMap<>();
        if (!testQuery.contains("&")) {
            int equalsPos1 = testQuery.indexOf("=");
            String firstParameterName1 = testQuery.substring(0, equalsPos1);
            String firstParameterValue1 = testQuery.substring(equalsPos1 +1);
            convertedQuery.put(firstParameterName1, firstParameterValue1);
        } else if (testQuery.contains("&")) {
            int splitInt = testQuery.indexOf("&");

            String firstPart = testQuery.substring(0, splitInt);
            String secondPart = testQuery.substring(splitInt + 1);

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
