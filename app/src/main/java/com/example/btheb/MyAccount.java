package com.example.btheb;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyAccount extends AppCompatActivity {

    Button btnLogOut;
    ImageView imvBack;
    TextView txtEditName, txtEditInfo, txtOpenMyOrder,txtname,txtemail,txtphone,txtaddress1,txtaddress2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnLogOut = findViewById(R.id.btnLogout);
        imvBack = findViewById(R.id.imvBack);
        txtEditInfo = findViewById(R.id.txtEditInfo);
        txtEditName = findViewById(R.id.txtEditName);
        txtOpenMyOrder = findViewById(R.id.txtOpenMyOrder);
        txtemail = findViewById(R.id.txtemail);
        txtname = findViewById(R.id.txtname);
        txtphone = findViewById(R.id.txtphone);
        txtaddress1 = findViewById(R.id.txtaddress1);
        txtaddress2 = findViewById(R.id.txtaddress2);
    }

    private void addEvents() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAccount.this, SignIn.class));
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtOpenMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAccount.this, Track_My_Order.class));
            }
        });
        txtEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MyAccount.this);
                dialog.setContentView(R.layout.layout_popup_editname);
                dialog.setCanceledOnTouchOutside(false);
                EditText edtName = dialog.findViewById(R.id.edtname);
                EditText edtMail = dialog.findViewById(R.id.edtemail);
                edtName.setText(txtname.getText());
                edtMail.setText(txtemail.getText());
                ImageView imvClose = dialog.findViewById(R.id.imvclose);
                imvClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button btnSave = dialog.findViewById(R.id.btnsave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtname.setText(edtName.getText());
                        txtemail.setText(edtMail.getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        txtEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MyAccount.this);
                dialog.setContentView(R.layout.layout_popup_editaddress);
                dialog.setCanceledOnTouchOutside(false);
                EditText edtPhone = dialog.findViewById(R.id.edtphone);
                EditText edtAdress1 = dialog.findViewById(R.id.edtaddress1);
                EditText edtAdress2 = dialog.findViewById(R.id.edtaddress2);
                edtPhone.setText(txtphone.getText());
                edtAdress1.setText(txtaddress1.getText());
                edtAdress2.setText(txtaddress2.getText());
                ImageView imvClose = dialog.findViewById(R.id.imvclose);
                imvClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button btnSave = dialog.findViewById(R.id.btnSave_address);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtaddress1.setText(edtAdress1.getText());
                        txtaddress2.setText(edtAdress2.getText());
                        txtphone.setText(edtPhone.getText());
                        dialog.dismiss();                    }
                });
                dialog.show();
            }
        });
    }
}