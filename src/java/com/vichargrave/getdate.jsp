<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%
    System.out.println("ddddddd");
    DataBase db = new DataBase();
    String query = request.getParameter("q");     
    List<String> countries = db.getData(query);
 
    Iterator<String> iterator = countries.iterator();
    while(iterator.hasNext()) {
        String country = (String)iterator.next();
        out.println(country);
    }
%>