package ru.sbt.bit.ood.solid.homework;

import java.util.ArrayList;
import java.util.List;

public class HtmlGeneration {

    public static StringBuffer createTableHtml(ArrayList<ArrayList<String>> arrayTrTd){
        StringBuffer htmlString=new StringBuffer("<table>");
        for(List<String> arrayTr : arrayTrTd){
            htmlString.append("<tr>");
            for(String valueCell : arrayTr){
                htmlString.append("<td>").append(valueCell).append("</td>");
            }
            htmlString.append("</tr>");
        }
        htmlString.append("</table>");
        return htmlString;
    }

    public static StringBuffer addToHtmlBody(StringBuffer htmlString){
        return new StringBuffer("<html><body>")
                .append(htmlString)
                .append("</body></html>");
    }
}
