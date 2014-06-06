/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vichargrave;

import java.sql.Connection;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
@Path("hello")
public class PageLoad {
    DataBase dB = new DataBase();
    
    @Context
    private UriInfo context;
    public PageLoad()
    {
         dB = new DataBase();
    } 
    
     @Path("index")
     @GET
     @Produces("text/html")
   public String getIndex( @DefaultValue("Nothing to say") @QueryParam("value") String name) {       
       
       Thread pi = new Thread(new PageIndex(name, dB));
       pi.start();
       return "<h1>Индексация страницы:"+name+"</h1>";
   }
     @Path("clean")
     @GET
       @Produces("text/html")
   public String getClean() {
        return "<h1>Таблица очищена</h1>";
    }
    @Path("givetable")
       @GET
    @Produces("text/html")
   public String getTable() {
       
        return "<h1>"+dB.selectAll()+"</h1>";
    }
  @Path("suggest")
    @GET
    @Produces("text/html") 
  public String suggest() {
    System.out.println("ddddddd");     
        return 

" <html>\n" +
"<head>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n" +
"<script type=\"text/javascript\" src=\"js/jquery-1.4.2.min.js\"></script>\n" +
"<script src=\"js/jquery.autocomplete.js\"></script>\n" +
"<script>\n" +
"jQuery(function(){\n" +
"$(\"#name\").autocomplete(\"getdata.jsp\");\n" +
"});\n" +
"</script>\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"<br><br><center>\n" +
"<font face=\"verdana\" size=\"2\">\n" +
"<font size=\"4\">jsp and jQuery Autocompleter Example ::: <font color=\"#809e02\">http://corejavaexample.blogspot.in/</font></font>\n" +
"<br><br><br><br>\n" +
"\n" +
"Select Country   :\n" +
"<input type=\"text\" id=\"name\" name=\"name\"/>\n" +
"\n" +
"</font>\n" +
"</body>\n" +
"</html>"                  ;
}
  
    @Path("hello2")
    @GET
    @Produces("text/html")
   public String getHtml2() {
       
        return "<h1>Ну что поехали2))</h1>";
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
   public String getHtml() {
       
        return   "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf8\" />"
                + "<h1>Лабораторная работа номер 3</h1>"
                + "<h1>Точилина Светлана Константиновна </h1>" 
             + "<font color=#0000ff size=\"8\"><p> Для индексации  - /index?value=INDEXNAME <br>" 
               + " Для поиска  - /find<br>"
                +  "Для очистки данных - /clean<br>"
               + "Для Вывода таблицы - givetable</p> ";

    }
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
