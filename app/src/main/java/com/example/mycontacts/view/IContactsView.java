package com.example.mycontacts.view;


import android.os.Bundle;

public interface IContactsView {
    void displayContacts(Bundle contacts);

    void showProgressDialog();

    void dismissProgressDialog();
}
