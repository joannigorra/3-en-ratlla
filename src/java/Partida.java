import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jordipc
 */
public class Partida extends HttpServlet {
    
   @Override
    public void init() throws ServletException {
        super.init();
        int x= 0;
        int jugades = 0;
        ServletContext c = getServletContext();
        c.setAttribute("cont", x);//comptador per les sessions      
        ServletContext d = getServletContext();
        //c.setAttribute("torn", jugades);
        /*ServletContext d = getServletContext();
        d.setAttribute("torn", jugades); */
     
     }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
            String user = req.getParameter("user");           
	    response(resp, "Jugador validat!",user);                                         
	}

	private void response(HttpServletResponse resp, String msg,String user)
			throws IOException {
            
            ServletContext c = getServletContext();
                Integer x = (Integer) c.getAttribute("cont");
                
                x++;
                //string jugadors
                String jugador1;             
                ServletContext d = getServletContext();
                Integer num = (Integer)d.getAttribute("torn");
               
                
                if( num %2==0){
                    jugador1="Tira el rival";
                }else{
                    jugador1="Tires tu";
                }
                //missatge si taulells no estan reiniciats
                Taulell taula[]= (Taulell[])getServletContext().getAttribute("ArrayTaulells");//array dels taulells
                c.setAttribute("cont",x);
                PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body style='font-family:arial;'>");
		out.println("<t1>" + msg + "</t1><br>");   
                out.println("<br>");
                out.println("<t1>" + "<b>Nom Jugador:</b> "+ user + "</t1><br>");   
                out.println("<t1>" + "<b>Sessió:</b> "+ x + "</t1>");                  
                out.println("<br><br><br><center>");
                out.println("<form action='Torntirada' method='post'>");
                out.println("<table style='font-size:24px'>");
                out.println("<tr><td><input type='submit' id='1' value="+taula[1].estatPosicio(0,0)+"></td>");
                out.println("<td><input     type='submit' id='2' value="+taula[1].estatPosicio(0,1)+"></td>");
                out.println("<td><input     type='submit' id='3' value="+taula[1].estatPosicio(0,2)+"></td></tr>");
                out.println("<tr><td><input type='submit' id='4' value="+taula[1].estatPosicio(1,0)+"></td>");
                out.println("<td>    <input type='submit' id='5' value="+taula[1].estatPosicio(1,1)+"></td>");
                out.println("<td>    <input type='submit' id='6' value="+taula[1].estatPosicio(1,2)+"></td>");
                out.println("<tr><td><input type='submit' id='7' value="+taula[1].estatPosicio(2,0)+"></td>");
                out.println("<td>    <input type='submit' id='8' value="+taula[1].estatPosicio(2,1)+"></td>");
                out.println("<td>    <input type='submit' id='9' value="+taula[1].estatPosicio(2,2)+"></td></tr>");                
                out.println("</table></center></form>");  
                out.println("<br><br>");  
                out.println("<t1>" + "<b>Torn del Jugador:</b></t1> "+jugador1+"<br>");
                //out.println("<t1>" + "<b>Jugades:</b></t1> "+jugades+"<br>"); 
                //out.println("<t1>" + "<b>Torn:</b></t1> "+torn+"<br>"); 
                out.println("<t1>" + "<b>Nom rival:</b></t1>"+"0"+"<br>");  
                out.println("<br>");
                out.println("</body>");
		out.println("</html>");
	}    


   
}
