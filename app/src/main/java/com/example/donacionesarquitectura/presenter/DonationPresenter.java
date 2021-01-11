package com.example.donacionesarquitectura.presenter;

import com.example.donacionesarquitectura.model.DonationModel;

public class DonationPresenter {

    private IViewPresenter view;
    private DonationModel model;

    public DonationPresenter(IViewPresenter view) {
        this.view = view;
        this.model = new DonationModel();
    }

    public void saveDonation(String donation) {
        int total = model.validateString(donation);
        if (total > 0) {
            if (model.saveDonation(total)){
                view.displayConfirmationMessage();
                view.updateTotalDonation(model.getTotalDonation());
            }
        } else {
            view.displayErrorMessage();
        }
    }

}
