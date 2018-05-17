/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ParkingLot;

/**
 *
 * @author Michael
 */
public class ParkingLotDB {
    private ArrayList<ParkingLot> tenLotList;
    private ArrayList<ParkingLot> noonLotList;
    private ArrayList<ParkingLot> twoLotList;
    private ArrayList<ParkingLot> fourLotList;
    private ParkingLot lot;
    
    public static ParkingLot getParkingLot(String code) {

        ParkingLot parkingLot = new ParkingLot();

        String query = "SELECT CarparkAbbr, CarparkDesig, CurrentLevel, Capacity FROM PARK_DB.dbo.CPCounting " +
                "WHERE CountingCategory = 'Total' AND CarparkAbbr != 'S&VMs' " +
                "AND CarparkAbbr != 'ED2/3' AND CarparkAbbr = " + code + ";";
        Statement statement = DbConnection.getNewStatement();
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                parkingLot.setLotCode(code);
                parkingLot.setName(resultSet.getString("CarparkDesig"));
                parkingLot.setMax(resultSet.getInt("Capacity"));
                parkingLot.setCurrentAvailable(resultSet.getInt("CurrentLevel"));
                parkingLot.setPercentFilled(resultSet.getInt("Capacity"), resultSet.getInt("CurrentLevel"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parkingLot;

    }

    public static ArrayList<ParkingLot> getAllParkingLots() {
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

        Statement statement = DbConnection.getNewStatement();
        ResultSet resultSet = null;

        String code = "";
        String name = "";
        int capacity = 0;
        int currentlyAvailable = 0;

        try {

            resultSet = statement.executeQuery(
                    "SELECT CarparkAbbr, CarparkDesig, CurrentLevel, Capacity FROM PARK_DB.dbo.CPCounting " +
                    "WHERE CountingCategory = 'Total' AND CarparkAbbr != 'S&VMs' AND CarparkAbbr != 'ED2/3' " +
                    "ORDER BY CarparkDesig;");
            while (resultSet.next()) {
                code = resultSet.getString("CarparkAbbr");
                name = resultSet.getString("CarparkDesig");
                capacity = resultSet.getInt("Capacity");
                currentlyAvailable = resultSet.getInt("CurrentLevel");

                ParkingLot parkingLot = new ParkingLot(code, name, capacity, currentlyAvailable);
                parkingLots.add(parkingLot);
                System.out.println("Found parkingLot in ParkingLot table: " + code);
                System.out.println("Capacity: " + capacity);
                System.out.println("Filled: " + currentlyAvailable);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ParkingLotDB.getAllParkingLots()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return parkingLots;
    }
    
    /**
    public ArrayList<ParkingLot> getTenLotList() {
        return tenLotList;
    }
    
    public ArrayList<ParkingLot> getNoonLotList() {
        return noonLotList;
    }
    
    public ArrayList<ParkingLot> getTwoLotList() {
        return twoLotList;
    }
    
    public ArrayList<ParkingLot> getFourLotList() {
        return fourLotList;
    }
    
    public void setTenLotList() {
        setLot("L26", "Lot 26", 86, 0);
        tenLotList.add(lot);
        setLot("ND", "North Deck", 1167, 516);
        tenLotList.add(lot);
        setLot("L25", "Lot 25", 481, 41);
        tenLotList.add(lot);
        setLot("UD", "Union Deck", 567, 0);
        tenLotList.add(lot);
        setLot("CRI1", "CRI Deck 1", 1300, 664);
        tenLotList.add(lot);
        setLot("CRI2", "CRI Lot 2", 129, 0);
        tenLotList.add(lot);
        setLot("L23", "Lot 23", 180, 0);
        tenLotList.add(lot);
        setLot("L14", "Lot 14", 22, 1);
        tenLotList.add(lot);
        setLot("WD", "West Deck", 763, 0);
        tenLotList.add(lot);
        setLot("L7A", "Lot 7A", 38, 0);
        tenLotList.add(lot);
        setLot("L7", "Lot 7", 112, 0);
        tenLotList.add(lot);
        setLot("L101", "Lot 101", 61, 12);
        tenLotList.add(lot);
        setLot("SVD", "South Village Deck", 1092, 111);
        tenLotList.add(lot);
        setLot("L8", "Lot 8", 245, 0);
        tenLotList.add(lot);
        setLot("L8A", "Lot 8A", 52, 0);
        tenLotList.add(lot);
        setLot("L16", "Lot 16", 131, 1);
        tenLotList.add(lot);
        setLot("L20", "Lot 20", 105, 0);
        tenLotList.add(lot);
        setLot("L21", "Lot 21", 133, 1);
        tenLotList.add(lot);
        setLot("L12", "Lot 12", 51, 2);
        tenLotList.add(lot);
        setLot("L13", "Lot 13", 138, 1);
        tenLotList.add(lot);
        setLot("GV", "Greek Village", 330, 130);
        tenLotList.add(lot);
        setLot("L6", "Lot 6", 602, 62);
        tenLotList.add(lot);
        setLot("L5", "Lot 5", 580, 0);
        tenLotList.add(lot);
        setLot("L5A", "Lot 5A", 251, 11);
        tenLotList.add(lot);
        setLot("L4A", "Lot 4A", 127, 2);
        tenLotList.add(lot);
        setLot("ED3", "East Deck 3", 807, 15);
        tenLotList.add(lot);
        setLot("ED2", "East Deck 2", 518, 0);
        tenLotList.add(lot);
    }

    public void setNoonLotList() {
        setLot("L26", "Lot 26", 86, 1);
        noonLotList.add(lot);
        setLot("ND", "North Deck", 1167, 317);
        noonLotList.add(lot);
        setLot("L25", "Lot 25", 481, 37);
        noonLotList.add(lot);
        setLot("UD", "Union Deck", 567, 3);
        noonLotList.add(lot);
        setLot("CRI1", "CRI Deck 1", 1300, 675);
        noonLotList.add(lot);
        setLot("CRI2", "CRI Lot 2", 129, 0);
        noonLotList.add(lot);
        setLot("L23", "Lot 23", 180, 2);
        noonLotList.add(lot);
        setLot("L14", "Lot 14", 22, 1);
        noonLotList.add(lot);
        setLot("WD", "West Deck", 763, 10);
        noonLotList.add(lot);
        setLot("L7A", "Lot 7A", 38, 0);
        noonLotList.add(lot);
        setLot("L7", "Lot 7", 112, 0);
        noonLotList.add(lot);
        setLot("L101", "Lot 101", 61, 18);
        noonLotList.add(lot);
        setLot("SVD", "South Village Deck", 1092, 85);
        noonLotList.add(lot);
        setLot("L8", "Lot 8", 245, 1);
        noonLotList.add(lot);
        setLot("L8A", "Lot 8A", 52, 0);
        noonLotList.add(lot);
        setLot("L16", "Lot 16", 131, 1);
        noonLotList.add(lot);
        setLot("L20", "Lot 20", 105, 1);
        noonLotList.add(lot);
        setLot("L21", "Lot 21", 133, 0);
        noonLotList.add(lot);
        setLot("L12", "Lot 12", 51, 1);
        noonLotList.add(lot);
        setLot("L13", "Lot 13", 138, 1);
        noonLotList.add(lot);
        setLot("GV", "Greek Village", 330, 130);
        noonLotList.add(lot);
        setLot("L6", "Lot 6", 602, 35);
        noonLotList.add(lot);
        setLot("L5", "Lot 5", 580, 25);
        noonLotList.add(lot);
        setLot("L5A", "Lot 5A", 251, 21);
        noonLotList.add(lot);
        setLot("L4A", "Lot 4A", 127, 10);
        noonLotList.add(lot);
        setLot("ED3", "East Deck 3", 807, 37);
        noonLotList.add(lot);
        setLot("ED2", "East Deck 2", 518, 7);
        noonLotList.add(lot);
    }
    
    public void setTwoLotList() {
        setLot("L26", "Lot 26", 86, 5);
        twoLotList.add(lot);
        setLot("ND", "North Deck", 1167, 393);
        twoLotList.add(lot);
        setLot("L25", "Lot 25", 481, 40);
        twoLotList.add(lot);
        setLot("UD", "Union Deck", 567, 25);
        twoLotList.add(lot);
        setLot("CRI1", "CRI Deck 1", 1300, 738);
        twoLotList.add(lot);
        setLot("CRI2", "CRI Lot 2", 129, 2);
        twoLotList.add(lot);
        setLot("L23", "Lot 23", 180, 1);
        twoLotList.add(lot);
        setLot("L14", "Lot 14", 22, 1);
        twoLotList.add(lot);
        setLot("WD", "West Deck", 763, 30);
        twoLotList.add(lot);
        setLot("L7A", "Lot 7A", 38, 1);
        twoLotList.add(lot);
        setLot("L7", "Lot 7", 112, 0);
        twoLotList.add(lot);
        setLot("L101", "Lot 101", 61, 12);
        twoLotList.add(lot);
        setLot("SVD", "South Village Deck", 1092, 97);
        twoLotList.add(lot);
        setLot("L8", "Lot 8", 245, 4);
        twoLotList.add(lot);
        setLot("L8A", "Lot 8A", 52, 2);
        twoLotList.add(lot);
        setLot("L16", "Lot 16", 131, 1);
        twoLotList.add(lot);
        setLot("L20", "Lot 20", 105, 1);
        twoLotList.add(lot);
        setLot("L21", "Lot 21", 133, 1);
        twoLotList.add(lot);
        setLot("L12", "Lot 12", 51, 2);
        twoLotList.add(lot);
        setLot("L13", "Lot 13", 138, 2);
        twoLotList.add(lot);
        setLot("GV", "Greek Village", 330, 148);
        twoLotList.add(lot);
        setLot("L6", "Lot 6", 602, 107);
        twoLotList.add(lot);
        setLot("L5", "Lot 5", 580, 63);
        twoLotList.add(lot);
        setLot("L5A", "Lot 5A", 251, 45);
        twoLotList.add(lot);
        setLot("L4A", "Lot 4A", 127, 22);
        twoLotList.add(lot);
        setLot("ED3", "East Deck 3", 807, 99);
        twoLotList.add(lot);
        setLot("ED2", "East Deck 2", 518, 28);
        twoLotList.add(lot);
    }
    
    public void setFourLotList() {
        setLot("L26", "Lot 26", 86, 36);
        fourLotList.add(lot);
        setLot("ND", "North Deck", 1167, 485);
        fourLotList.add(lot);
        setLot("L25", "Lot 25", 481, 123);
        fourLotList.add(lot);
        setLot("UD", "Union Deck", 567, 98);
        fourLotList.add(lot);
        setLot("CRI1", "CRI Deck 1", 1300, 865);
        fourLotList.add(lot);
        setLot("CRI2", "CRI Lot 2", 129, 31);
        fourLotList.add(lot);
        setLot("L23", "Lot 23", 180, 5);
        fourLotList.add(lot);
        setLot("L14", "Lot 14", 22, 6);
        fourLotList.add(lot);
        setLot("WD", "West Deck", 763, 140);
        fourLotList.add(lot);
        setLot("L7A", "Lot 7A", 38, 6);
        fourLotList.add(lot);
        setLot("L7", "Lot 7", 112, 7);
        fourLotList.add(lot);
        setLot("L101", "Lot 101", 61, 43);
        fourLotList.add(lot);
        setLot("SVD", "South Village Deck", 1092, 243);
        fourLotList.add(lot);
        setLot("L8", "Lot 8", 245, 16);
        fourLotList.add(lot);
        setLot("L8A", "Lot 8A", 52, 1);
        fourLotList.add(lot);
        setLot("L16", "Lot 16", 131, 4);
        fourLotList.add(lot);
        setLot("L20", "Lot 20", 105, 2);
        fourLotList.add(lot);
        setLot("L21", "Lot 21", 133, 6);
        fourLotList.add(lot);
        setLot("L12", "Lot 12", 51, 12);
        fourLotList.add(lot);
        setLot("L13", "Lot 13", 138, 3);
        fourLotList.add(lot);
        setLot("GV", "Greek Village", 330, 140);
        fourLotList.add(lot);
        setLot("L6", "Lot 6", 602, 209);
        fourLotList.add(lot);
        setLot("L5", "Lot 5", 580, 143);
        fourLotList.add(lot);
        setLot("L5A", "Lot 5A", 251, 113);
        fourLotList.add(lot);
        setLot("L4A", "Lot 4A", 127, 57);
        fourLotList.add(lot);
        setLot("ED3", "East Deck 3", 807, 356);
        fourLotList.add(lot);
        setLot("ED2", "East Deck 2", 518, 119);
        fourLotList.add(lot);
    }
    **/

    public ParkingLot getLot() {
        return lot;
    }

    public void setLot(String lotCode, String name, int max, int currentAvailable) {
        lot = new ParkingLot();
        lot.setLotCode(lotCode);
        lot.setName(name);
        lot.setMax(max);
        lot.setCurrentAvailable(currentAvailable);
        lot.setPercentFilled(max, currentAvailable);
    }

    
}
