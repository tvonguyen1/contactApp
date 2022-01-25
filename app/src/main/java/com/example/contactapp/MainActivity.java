package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListButton();
        initMapButton();
        initSettingButton();
        initToggleButton();
        setForEditing(false);
        initChangeDateButton();
    }
    private void initListButton() {
        ImageButton ibList = findViewById(R.id.contactList);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void initMapButton() {
        ImageButton ibList = findViewById(R.id.map);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    private void initSettingButton() {
        ImageButton ibList = findViewById(R.id.setting);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    private void initToggleButton() {
        final ToggleButton editToggle = (ToggleButton)findViewById(R.id.toggleButtoneEdit);
        editToggle.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setForEditing(editToggle.isChecked());
            }

        });
    }
    private void setForEditing (boolean enabled) {
        EditText editName = findViewById (R.id. editName);
        EditText editAddress = findViewById (R.id. editAddress);
        EditText editCity = findViewById(R.id.editCity);
        EditText editState = findViewById (R.id.editState) ;
        EditText editZipCode = findViewById(R.id. editZipcode);
        EditText editPhone = findViewById (R.id. editHome);
        EditText editCell = findViewById (R.id.editCell) ;
        EditText editEmail = findViewById (R.id.editEmail);
        Button buttonChange = findViewById (R.id.btnBirthday);
        Button buttonSave = findViewById (R.id. buttonSave);

        editName.setEnabled (enabled) ;
        editAddress.setEnabled (enabled) ;
        editCity.setEnabled(enabled);
        editState.setEnabled(enabled);
        editZipCode.setEnabled (enabled);
        editPhone.setEnabled (enabled);
        editCell.setEnabled (enabled);
        editEmail.setEnabled(enabled);
        buttonChange.setEnabled(enabled);
        buttonSave.setEnabled(enabled);
        if (enabled)
            editName.requestFocus () ;
    }

    @Override
    public void didFinishDatePickerDialog(Calendar selectedTime) {
        TextView birthDay = findViewById(R.id.textBirthday);
        birthDay.setText(DateFormat.format("MM/dd/yyyy", selectedTime));


    }
    private void initChangeDateButton() {
        Button changeDate = findViewById (R.id.btnBirthday);
        changeDate.setOnClickListener (new View.OnClickListener() {

            public void onClick (View view) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm,"DatePick");
            }
        });
    }
}