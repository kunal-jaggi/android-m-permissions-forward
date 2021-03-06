package com.example.mycontacts.presenter;

import com.example.mycontacts.presenter.model.IDeviceContacts;
import com.example.mycontacts.presenter.model.impl.DeviceContacts;
import com.example.mycontacts.view.IContactsView;
import com.example.mycontacts.view.impl.MyContactsActivity;

public class MyContactsPresenter {

    private IDeviceContacts mDeviceContacts;

    private IContactsView view;

    public IContactsView getView() {
        return view;
    }

    public void setView(IContactsView view) {
        this.view = view;
    }

    public MyContactsPresenter() {
        this(new DeviceContacts());
    }

    public MyContactsPresenter(IDeviceContacts mDeviceContacts) {
        this.mDeviceContacts = mDeviceContacts;
    }

    public void didFinishLoading() {
        IContactsView view = getView();
        view.showProgressDialog();
        view.displayContacts(mDeviceContacts.retrieveContacts((MyContactsActivity) getView()));
        view.dismissProgressDialog();
    }

}
