package no.innlevering;

import javax.lang.model.util.Types;
import java.util.HashMap;

public class QueryString {

    private static String queryString;

    public QueryString() {
        this("");
    }

    public QueryString(String queryString) {
        this.queryString = queryString;
        checkForÆØÅinParameterValues();
    }

    public String getParameter(String parameterName) {
        HashMap<String, String> convertedQuery = new HashMap<>();
        if(queryString.contains("?")){
            int equal = queryString.indexOf("?");
            if(equal == 0){
                queryString = queryString.substring(1);
            }
        }

        if(queryString.contains("&")) {
            for (String parameter : queryString.split("&")) {
                int equal = parameter.indexOf("=");
                String name = parameter.substring(0, equal);
                String value = parameter.substring(equal+1);
                convertedQuery.put(name.toLowerCase(), value);
            }
        } else {
            int equalsPos1 = queryString.indexOf("=");
            String firstParameterName1 = queryString.substring(0, equalsPos1);
            String firstParameterValue1 = queryString.substring(equalsPos1 +1);
            convertedQuery.put(firstParameterName1.toLowerCase(), firstParameterValue1);
        }
        /*
        //Lar dette stå så man ser hva vi gjorde først..

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
        */
        String parameterValue = "";
        if (convertedQuery.containsKey(parameterName.toLowerCase())) {
            parameterValue = convertedQuery.get(parameterName.toLowerCase());

            // returner "%20" som " "
            if(parameterValue.contains("%20")) {
                parameterValue = parameterValue.replace("%20", " ");
            }

            return parameterValue;
        } else {
            return "-1"; // burde throwe i stedet?
        }
    }

    public void addParameter(String name, String value) {
        if(value.contains(" ")) {
            value = value.replaceAll(" ", "%20");
        }
        if (queryString == "") {
            queryString += "?"+name + "=" + value;
        } else {
            queryString += "&" + name + "=" + value;
        }
        checkForÆØÅinParameterValues();
    }

    public String getQueryString() {
        return queryString;
    }

    private void checkForÆØÅinParameterValues() {
        if(queryString.contains("æ") || queryString.contains("æ") || queryString.contains("å")) {
            if(!queryString.contains("UTF-8")) {
                this.addParameter("ie", "UTF-8");
            }
        }
    }
}
