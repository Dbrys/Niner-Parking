/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class ParkingLot implements Serializable{
    private String lotCode;
    private String name;
    private float max;
    private float currentAvailable;
    private int percentFilled;
    private String style;
    private String mapLink;
    
    public ParkingLot() {
        lotCode = "";
        name = "";
        max = 0;
        currentAvailable = 0;
        percentFilled = 0;
        style = "";
    }

    public ParkingLot(String lotCode, String name, int max, int currentAvailable) {
        this.lotCode = lotCode;
        this.name = name;
        this.max = max;
        this.currentAvailable = currentAvailable;
        this.setPercentFilled(max, currentAvailable);
    }
    
    

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getCurrentAvailable() {
        return currentAvailable;
    }

    public void setCurrentAvailable(int currentAvailable) {
        this.currentAvailable = currentAvailable;
    }

    public int getPercentFilled() {
        return percentFilled;
    }

    public void setPercentFilled(int max, int curentAvailable) {
        percentFilled = (int) ((currentAvailable / max) * 100);
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMapLink() {
        return mapLink;
    }

    public void setMapLink(String mapLink) {
        this.mapLink = mapLink;
    }
    
    
    
}
