package com.example.donacionesarquitectura.model;

public class DonationModel {

    private int totalDonation;

    public DonationModel() {
        this.totalDonation = 0;
    }

    public boolean saveDonation(int nuevaDonacion){
        this.totalDonation = totalDonation + nuevaDonacion;
        return true;
    }

    public int validateString(String value){
        if (value.length() != 0){
            try {
                int donation = Integer.parseInt(value);
                return donation;
            }
            catch (NumberFormatException e){
                return -1;
            }
        } else {
           return -1;
        }
    }


    public int getTotalDonation() {
        return totalDonation;
    }


}
