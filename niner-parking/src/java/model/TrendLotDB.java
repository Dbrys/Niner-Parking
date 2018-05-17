/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class TrendLotDB {
    private ArrayList<ParkingLot> tenLotList;
    private ArrayList<ParkingLot> noonLotList;
    private ArrayList<ParkingLot> twoLotList;
    private ArrayList<ParkingLot> fourLotList;
    private ParkingLot lot;
    
    public TrendLotDB() {
        lot = new ParkingLot();
        tenLotList = new ArrayList<>();
        noonLotList = new ArrayList<>();
        twoLotList = new ArrayList<>();
        fourLotList = new ArrayList<>();
        setTenLotList();
        setNoonLotList();
        setTwoLotList();
        setFourLotList();
    }

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
        setLot("NORTH", "North Deck", 1167, 651, "https://maps.uncc.edu/#/?nav=pk&ctr=35.31338475574194,-80.73109675896067&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=B5239156-635A-4CF0-A096-60A9A7E1EE06");
        tenLotList.add(lot);
        setLot("UNION", "Union Deck", 567, 567, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30926225408154,-80.73459972393412&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=7A45A2E5-2FB5-4FA3-BE29-CD5973B7A89C");
        tenLotList.add(lot);
        setLot("CRI", "CRI Deck", 1300, 636, "https://maps.uncc.edu/#/?nav=pk&ctr=35.309751449629466,-80.74025382053752&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1202D6D9-1258-4FD3-A9F3-822D536D6F82");
        tenLotList.add(lot);
        setLot("WEST", "West Deck", 763, 763, "https://maps.uncc.edu/#/?nav=pk&ctr=35.305172376002766,-80.73388089191813&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=8596383F-B2F1-4E1F-9B02-5F1AF71E88C2");
        tenLotList.add(lot);
        setLot("SOUTH", "South Village Deck", 1092, 981, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30096080033669,-80.73469360124965&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1EE118F8-7653-4289-BFCF-AEA27F0EFCDE");
        tenLotList.add(lot);
        setLot("EAST", "East Deck", 518, 518, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30536500000001,-80.72682399999995&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=C1B9C7A8-629B-4C2C-96AC-2D50BBCB6614");
        tenLotList.add(lot);
        setLot("CD FS", "Cone Deck Faculty", 492, 189, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        tenLotList.add(lot);
        setLot("CD VS", "Cone Deck Visitor", 317, 60, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        tenLotList.add(lot);
        setLot("SHS", "SHS", 20, 18, "https://maps.uncc.edu/#/?nav=Pk&ctr=35.31012025953044,-80.72992463362117&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=87E3DA95-4DEC-4C47-A22D-F7B5463B6865");
        tenLotList.add(lot);
    }

    public void setNoonLotList() {
        setLot("NORTH", "North Deck", 1167, 850, "https://maps.uncc.edu/#/?nav=pk&ctr=35.31338475574194,-80.73109675896067&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=B5239156-635A-4CF0-A096-60A9A7E1EE06");
        noonLotList.add(lot);
        setLot("UNION", "Union Deck", 567, 564, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30926225408154,-80.73459972393412&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=7A45A2E5-2FB5-4FA3-BE29-CD5973B7A89C");
        noonLotList.add(lot);
        setLot("CRI", "CRI Deck", 1300, 625, "https://maps.uncc.edu/#/?nav=pk&ctr=35.309751449629466,-80.74025382053752&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1202D6D9-1258-4FD3-A9F3-822D536D6F82");
        noonLotList.add(lot);
        setLot("WEST", "West Deck", 763, 753, "https://maps.uncc.edu/#/?nav=pk&ctr=35.305172376002766,-80.73388089191813&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=8596383F-B2F1-4E1F-9B02-5F1AF71E88C2");
        noonLotList.add(lot);
        setLot("SOUTH", "South Village Deck", 1092, 1007, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30096080033669,-80.73469360124965&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1EE118F8-7653-4289-BFCF-AEA27F0EFCDE");
        noonLotList.add(lot);
        setLot("EAST", "East Deck", 518, 511, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30536500000001,-80.72682399999995&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=C1B9C7A8-629B-4C2C-96AC-2D50BBCB6614");
        noonLotList.add(lot);
        setLot("CD FS", "Cone Deck Faculty", 492, 280, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        noonLotList.add(lot);
        setLot("CD VS", "Cone Deck Visitor", 317, 184, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        noonLotList.add(lot);
        setLot("SHS", "SHS", 20, 20, "https://maps.uncc.edu/#/?nav=Pk&ctr=35.31012025953044,-80.72992463362117&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=87E3DA95-4DEC-4C47-A22D-F7B5463B6865");
        noonLotList.add(lot);
    }
    
    public void setTwoLotList() {
        setLot("NORTH", "North Deck", 1167, 774, "https://maps.uncc.edu/#/?nav=pk&ctr=35.31338475574194,-80.73109675896067&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=B5239156-635A-4CF0-A096-60A9A7E1EE06");
        twoLotList.add(lot);
        setLot("UNION", "Union Deck", 567, 542, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30926225408154,-80.73459972393412&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=7A45A2E5-2FB5-4FA3-BE29-CD5973B7A89C");
        twoLotList.add(lot);
        setLot("CRI", "CRI Deck", 1300, 562, "https://maps.uncc.edu/#/?nav=pk&ctr=35.309751449629466,-80.74025382053752&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1202D6D9-1258-4FD3-A9F3-822D536D6F82");
        twoLotList.add(lot);
        setLot("WEST", "West Deck", 763, 733, "https://maps.uncc.edu/#/?nav=pk&ctr=35.305172376002766,-80.73388089191813&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=8596383F-B2F1-4E1F-9B02-5F1AF71E88C2");
        twoLotList.add(lot);
        setLot("SOUTH", "South Village Deck", 1092, 995, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30096080033669,-80.73469360124965&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1EE118F8-7653-4289-BFCF-AEA27F0EFCDE");
        twoLotList.add(lot);
        setLot("EAST", "East Deck", 518, 498, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30536500000001,-80.72682399999995&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=C1B9C7A8-629B-4C2C-96AC-2D50BBCB6614");
        twoLotList.add(lot);
        setLot("CD FS", "Cone Deck Faculty", 492, 380, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        twoLotList.add(lot);
        setLot("CD VS", "Cone Deck Visitor", 317, 230, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        twoLotList.add(lot);
        setLot("SHS", "SHS", 20, 20, "https://maps.uncc.edu/#/?nav=Pk&ctr=35.31012025953044,-80.72992463362117&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=87E3DA95-4DEC-4C47-A22D-F7B5463B6865");
        twoLotList.add(lot);
    }
    
    public void setFourLotList() {
        setLot("NORTH", "North Deck", 1167, 682, "https://maps.uncc.edu/#/?nav=pk&ctr=35.31338475574194,-80.73109675896067&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=B5239156-635A-4CF0-A096-60A9A7E1EE06");
        fourLotList.add(lot);
        setLot("UNION", "Union Deck", 567, 469, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30926225408154,-80.73459972393412&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=7A45A2E5-2FB5-4FA3-BE29-CD5973B7A89C");
        fourLotList.add(lot);
        setLot("CRI", "CRI Deck", 1300, 435, "https://maps.uncc.edu/#/?nav=pk&ctr=35.309751449629466,-80.74025382053752&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1202D6D9-1258-4FD3-A9F3-822D536D6F82");
        fourLotList.add(lot);
        setLot("WEST", "West Deck", 763, 623, "https://maps.uncc.edu/#/?nav=pk&ctr=35.305172376002766,-80.73388089191813&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=8596383F-B2F1-4E1F-9B02-5F1AF71E88C2");
        fourLotList.add(lot);
        setLot("SOUTH", "South Village Deck", 1092, 849, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30096080033669,-80.73469360124965&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=1EE118F8-7653-4289-BFCF-AEA27F0EFCDE");
        fourLotList.add(lot);
        setLot("EAST", "East Deck", 518, 399, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30536500000001,-80.72682399999995&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-visitor,park-access,trans-lrs&navFlt=park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=C1B9C7A8-629B-4C2C-96AC-2D50BBCB6614");
        fourLotList.add(lot);
        setLot("CD FS", "Cone Deck Faculty", 492, 189, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        twoLotList.add(lot);
        setLot("CD VS", "Cone Deck Visitor", 317, 31, "https://maps.uncc.edu/#/?nav=pk&ctr=35.30384150676079,-80.73378701460261&z=18&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=0DFA79E8-8915-4B03-A968-6A1DF43357DD");
        twoLotList.add(lot);
        setLot("SHS", "SHS", 20, 15, "https://maps.uncc.edu/#/?nav=Pk&ctr=35.31012025953044,-80.72992463362117&z=19&blnd=t,cc-parking,cc-amenities&vis=t,park&vis=f,park-payStation,park-meter,park-access,trans-lrs&navFlt=park-visitor,park-rfs,park-disability,park-greek,park-fs,park-rcfs,park-spo,park-cfs,park-other,outage&pop=87E3DA95-4DEC-4C47-A22D-F7B5463B6865");
        twoLotList.add(lot);
    }

    public ParkingLot getLot() {
        return lot;
    }

    public void setLot(String lotCode, String name, int max, int currentAvailable, String mapLink) {
        lot = new ParkingLot();
        lot.setLotCode(lotCode);
        lot.setName(name);
        lot.setMax(max);
        lot.setCurrentAvailable(currentAvailable);
        lot.setPercentFilled(max, currentAvailable);
        lot.setMapLink(mapLink);
    }

}
