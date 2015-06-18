package com.example.mycontacts.view.impl;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycontacts.R;
import com.example.mycontacts.presenter.MyContactsPresenter;
import com.example.mycontacts.view.AbstractBaseActivity;
import com.example.mycontacts.view.IContactsView;

import butterknife.InjectView;
import butterknife.OnClick;

public class MyContactsActivity extends AbstractBaseActivity implements IContactsView {

    private MyContactsPresenter myContactsPresenter;

    @InjectView(R.id.txtContactsData)
    TextView mContactsData;

    @InjectView(R.id.txtContactsCount)
    TextView mContactsCount;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progress = new ProgressDialog(this);
        initMVP();
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_contacts;
    }

    private void initMVP() {
        myContactsPresenter = new MyContactsPresenter();
        myContactsPresenter.setView(this);
    }

    @Override
    public void displayContacts(Bundle contacts) {
        mContactsCount.setText("Total contacts: " + contacts.getInt("CONTACTS_COUNT"));
        mContactsData.setText(contacts.getString("CONTACTS_DATA"));
    }

    @Override
    public void showProgressDialog() {
        progress.setTitle(R.string.prg_title);
        progress.setMessage(getResources().getString(R.string.prg_msg));
        progress.show();
    }

    @Override
    public void dismissProgressDialog() {
        progress.dismiss();
    }


    @OnClick(R.id.btnReadContacts)
    public void loadContacts(Button button) {
        myContactsPresenter.didFinishLoading();
    }
}
