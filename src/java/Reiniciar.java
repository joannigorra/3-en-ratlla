/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jordipc
 */
public class Reiniciar extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //reiniciar els 5 taulells      
           Taulell T[]=new Taulell[5]; 
           
           for(int x=0;x<5;x++){    //iniciem els 5 taulells, que hauran d'estar disponibles hi per tan al contenidor d'objectes.
            T[x]= new Taulell();
           }           
           getServletContext().setAttribute("ArrayTaulells", T);//per enviar l'array...
           
        } finally {            
            out.close();
        }
    }
    
void reini(){
    if(getServletContext().getAttribute("torn")==null){
           getServletContext().setAttribute("torn", 0); 
       }
     Taulell T[]=new Taulell[5]; 
           
           for(int x=0;x<5;x++){    //iniciem els 5 taulells, que hauran d'estar disponibles hi per tan al contenidor d'objectes.
            T[x]= new Taulell();
           }           
           getServletContext().setAttribute("ArrayTaulells", T);//per enviar l'array...
           
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
