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
import model.TrendLotDB;

/**
 *
 * @author Michael
 */
public class ParkingLotController extends HttpServlet {

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
            out.println("<title>Servlet ParkingLotController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingLotController at " + request.getContextPath() + "</h1>");
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
        String lotCode = request.getParameter("lotCode");
        String action = request.getParameter("action");
        String type = request.getParameter("viewButton");
        HttpSession session = request.getSession();
        TrendLotDB trendLotDB = new TrendLotDB();
        ArrayList<ParkingLot> lotList = ParkingLotDB.getAllParkingLots();
        ArrayList<ParkingLot> tenLotList = trendLotDB.getTenLotList();
        ArrayList<ParkingLot> noonLotList = trendLotDB.getNoonLotList();
        ArrayList<ParkingLot> twoLotList = trendLotDB.getTwoLotList();
        ArrayList<ParkingLot> fourLotList = trendLotDB.getFourLotList();
        ArrayList<ParkingLot> trendLotList = new ArrayList<>();
        boolean lotNotFound = true;
        
        if(lotCode == null || lotCode.isEmpty()) {
            System.out.println("Lot code is empty or null");
            for(ParkingLot lot : lotList) {
                setStyle(lot, type, lot.getPercentFilled());
                System.out.println(lot.getPercentFilled());
            }
            session.setAttribute("style", type);
            session.setAttribute("LotData", lotList);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            for(int i = 0; i < lotList.size(); i++) {
                if(lotCode.equalsIgnoreCase(lotList.get(i).getLotCode())) {
                    lotNotFound = false;
                    for(ParkingLot lot : tenLotList){
                        if(lotCode.equalsIgnoreCase(lot.getLotCode())){
                            trendLotList.add(lot);
                        }
                    }
                    for(ParkingLot lot : noonLotList){
                        if(lotCode.equalsIgnoreCase(lot.getLotCode())){
                            trendLotList.add(lot);
                        }
                    }
                    for(ParkingLot lot : twoLotList){
                        if(lotCode.equalsIgnoreCase(lot.getLotCode())){
                            trendLotList.add(lot);
                        }
                    }
                    for(ParkingLot lot : fourLotList){
                        if(lotCode.equalsIgnoreCase(lot.getLotCode())){
                            trendLotList.add(lot);
                        }
                    }
                    for(ParkingLot lot : trendLotList) {
                        setStyle(lot, (String) session.getAttribute("style"), lot.getPercentFilled());
                    }
                    session.setAttribute("LotList", trendLotList);
                    session.setAttribute("LotData", trendLotList.get(0));
                    getServletContext().getRequestDispatcher("/trends.jsp").forward(request, response);
                }
            }

            if(lotNotFound) {
                for(ParkingLot lot : lotList) {
                    setStyle(lot, type, lot.getPercentFilled());
                }
                session.setAttribute("LotData", lotList);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        for(ParkingLot lot : lotList) {
            setStyle(lot, type, lot.getPercentFilled());
        }
        session.setAttribute("LotData", lotList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
