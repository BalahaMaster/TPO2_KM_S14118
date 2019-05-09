package zad1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {

    private String prolog =
            "<html><title>Przykład</title>" +
                    "<body background=\"images/os2.jpg\" text=\"antiquewhite\"" +
                    "link=\"white\" vlink=\"white\">";

    private String epilog = "</body></html>";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        response.setContentType("text/html; charset=ISO-8859-2");

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println(prolog);

        out.println("<h1>Dokument HTML<br>wygenerowany przez serwlet</h1>");
        out.println("<br><br><a href=\"Bye.html\">Pożegnanie</a>");

        out.println(epilog);
        out.close();
    }
}
