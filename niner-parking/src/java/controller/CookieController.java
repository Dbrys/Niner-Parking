/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DbConnection;
import model.ParkingLot;
import model.ParkingLotDB;

/**
 *
 * @author Michael
 */
public class CookieController extends HttpServlet {
    
    @Override
    public void init() throws ServletException{
        super.init();
        new DbConnection();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CookieController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ParkingLot> lotList = ParkingLotDB.getAllParkingLots();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String type = request.getParameter("viewButton");
        String style = (String) session.getAttribute("style");
        ArrayList<ParkingLot> faveLots = new ArrayList<>();
        ArrayList<ParkingLot> normLots = lotList;
        
        if(action == null || action.isEmpty()) {
            Cookie[] cookies = request.getCookies(); 
            if(cookies == null || cookies.length == 0) {
                getServletContext().getRequestDispatcher("/lotControl").forward(request, response);
            }else{
                for(ParkingLot lot : lotList) {
                    for(Cookie cookie : cookies) {
                        if(cookie.getValue().equalsIgnoreCase(lot.getLotCode())) {
                            faveLots.add(lot);
                        }
                    }
                }
                for(ParkingLot lot : faveLots) {
                    if(normLots.contains(lot)) {
                        normLots.remove(lot);
                    }
                }
                if(type != null && !type.isEmpty()) {
                    session.setAttribute("style", type);
                    style = type;
                }
                for(ParkingLot p : normLots) {
                    if(style != null && !style.isEmpty()) {
                        setStyle(p, style, p.getPercentFilled());
                    }else{
                        setStyle(p, type, p.getPercentFilled());
                    }
                }
                for(ParkingLot l : faveLots) {
                    if(style != null && !style.isEmpty()) {
                        setStyle(l, style, l.getPercentFilled());
                    }else{
                        setStyle(l, type, l.getPercentFilled());
                    }
                }
                session.setAttribute("FaveLots", faveLots);
                session.setAttribute("NormLots", normLots);
                getServletContext().getRequestDispatcher("/favoriteView.jsp").forward(request, response);
            }
        }else{
            if(action != null && !action.isEmpty()) {
                if(action.equalsIgnoreCase("setFave")) {
                    Cookie[] cookies = request.getCookies(); 
                    if(cookies != null && cookies.length != 0) {
                        for(Cookie cookie : cookies) {
                            cookie.setMaxAge(0);
                            cookie = new Cookie(cookie.getName(), "");
                            response.addCookie(cookie);
                        }
                    }
                    session.setAttribute("LotData", lotList);
                    getServletContext().getRequestDispatcher("/setFavorite.jsp").forward(request, response);
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String type = request.getParameter("viewButton");
        String style = (String) session.getAttribute("style");
        ArrayList<ParkingLot> lotList = ParkingLotDB.getAllParkingLots();
        ArrayList<ParkingLot> faveLots = new ArrayList<>();
        ArrayList<ParkingLot> normLots = lotList;
        
        if(action != null && !action.isEmpty()) {
            if(action.equalsIgnoreCase("saveFave")) {
                String[] favorites = request.getParameterValues("favorite");
                if(favorites != null) {
                    for(ParkingLot lot : lotList) {
                        System.out.println(lot.getLotCode());
                        for(String s : favorites) {
                            if(s.equalsIgnoreCase(lot.getLotCode())) {
                                faveLots.add(lot);
                            }
                        }
                    }
                }else{
                    Cookie[] cookies = request.getCookies(); 
                    if(cookies != null && cookies.length != 0) {
                        for(Cookie cookie : cookies) {
                            cookie.setMaxAge(0);
                            cookie = new Cookie(cookie.getName(), "");
                            response.addCookie(cookie);
                        }
                    }
                    getServletContext().getRequestDispatcher("/cookie").forward(request, response);
                }
                for(ParkingLot lot : faveLots) {
                    if(normLots.contains(lot)) {
                        normLots.remove(lot);
                    }
                }
                for(ParkingLot pl : faveLots) {
                    String st = pl.getLotCode();
                    Cookie c = new Cookie(st.replaceAll("\\s", ""), pl.getLotCode());
                    c.setMaxAge(60*60*24*365*3);
                    response.addCookie(c);
                }
                for(ParkingLot p : normLots) {
                    if(style != null && !style.isEmpty()) {
                        setStyle(p, style, p.getPercentFilled());
                    }else{
                        setStyle(p, type, p.getPercentFilled());
                    }
                }
                for(ParkingLot l : faveLots) {
                    if(style != null && !style.isEmpty()) {
                        setStyle(l, style, l.getPercentFilled());
                    }else{
                        setStyle(l, type, l.getPercentFilled());
                    }
                }
                session.setAttribute("FaveLots", faveLots);
                session.setAttribute("NormLots", normLots);
                getServletContext().getRequestDispatcher("/favoriteView.jsp").forward(request, response);
            }
        }
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

    public void setStyle(ParkingLot lot, String type, int percent) {
        String fillGrade = "";
        if(percent < 10) {
            fillGrade = "low10";
        }
        else if(percent >= 10 & percent < 20) {
            fillGrade = "low20";
        }
        else if(percent >= 20 & percent < 30) {
            fillGrade = "low30";
        }
        else if(percent >= 30 & percent < 40) {
            fillGrade = "mid40";
        }
        else if(percent >= 40 & percent < 50) {
            fillGrade = "mid50";
        }
        else if(percent >= 50 & percent < 60) {
            fillGrade = "mid60";
        }
        else if(percent >= 60 & percent < 70) {
            fillGrade = "mid70";
        }
        else if(percent >= 70 & percent < 80) {
            fillGrade = "high80";
        }
        else if(percent >= 80 & percent < 90) {
            fillGrade = "high90";
        }
        else if(percent >= 90 & percent <= 100) {
            fillGrade = "high100";
        }
        if(type != null && !type.isEmpty()) {
            lot.setStyle("percentColumn " + fillGrade + " " + type.toLowerCase());
        }else{
            lot.setStyle("percentColumn " + fillGrade + " gradient");
        }
    }
}
