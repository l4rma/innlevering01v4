package no.innlevering;

public class QueryString {


    public static String getParameter(String parameterName, String testQuery) {
        String statusValue = "";
        if (parameterName == "status") {
            int indexOfEqual = testQuery.indexOf("=");
            statusValue = testQuery.substring(indexOfEqual + 1);
        }
            return statusValue;

    }
}
