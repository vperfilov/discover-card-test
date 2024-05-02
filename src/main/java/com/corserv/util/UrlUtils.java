package com.corserv.util;

public class UrlUtils {

    /**
     * Inserts a parameter at the beginning of the query part of a URL.
     * @param originalUrl The original URL.
     * @param parameterName The name of the parameter to insert.
     * @param parameterValue The value of the parameter to insert.
     * @return The modified URL with the new parameter inserted.
     */
    public static String insertParameter(String originalUrl, String parameterName, String parameterValue) {
        int index = originalUrl.indexOf("?") + 1;
        if (index > 0 && index < originalUrl.length()) {
            StringBuilder modifiedUrl = new StringBuilder(originalUrl);
            if (index < originalUrl.length() - 1) {
                modifiedUrl.insert(index, parameterName + "=" + parameterValue + "&");
            } else {
                modifiedUrl.append(parameterName + "=" + parameterValue);
            }
            return modifiedUrl.toString();
        }
        return originalUrl; 
    }
}
