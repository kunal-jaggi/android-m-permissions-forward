package com.example.mycontacts.view.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycontacts.presenter.MyContactsPresenter;
import com.example.mycontacts.R;
import com.example.mycontacts.view.IContactsView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyContactsActivity extends Activity implements IContactsView {

    MyContactsPresenter myContactsPresenter;

    @InjectView(R.id.txtContactsData)
    TextView mContactsData;

    @InjectView(R.id.txtContactsCount)
    TextView mContactsCount;

    private ProgressDialog progress;
private static String TAG="MyContactsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        progress = new ProgressDialog(this);

        initBK();
        initMVP();

    }

    private void initBK(){
        ButterKnife.inject(this);
    }

    private void initMVP(){
        myContactsPresenter = new MyContactsPresenter();
        myContactsPresenter.setView(this);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_contacts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    public void displayContacts(Bundle contacts) {
        Log.i(TAG,"count: "+contacts.getInt("CONTACTS_COUNT"));
        Log.i(TAG,"data : "+contacts.getString("CONTACTS_DATA"));

        mContactsCount.setText("Total contacts: " + contacts.getInt("CONTACTS_COUNT"));
        mContactsData.setText(contacts.getString("CONTACTS_DATA"));
    }

    @Override
    public void showProgressDialog() {
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
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
