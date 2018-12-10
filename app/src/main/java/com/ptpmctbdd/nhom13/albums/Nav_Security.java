package com.ptpmctbdd.nhom13.albums;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Nav_Security extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__security);


        final EditText currentPassword = (EditText) findViewById(R.id.currentPassword);
        final EditText newPassword = (EditText) findViewById(R.id.newPassword);
        final EditText reNewPassword = (EditText) findViewById(R.id.reNewPassword);
        Button btnChange = (Button) findViewById(R.id.changePassword);
        Button btnCancel = (Button) findViewById(R.id.cancelChangePassword);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentpass  = currentPassword.getText().toString().trim();
                String newpass  = newPassword.getText().toString().trim();
                String renewpass = reNewPassword.getText().toString().trim();

                if (currentpass.equals(Albums.password))
                {
                    if (!newpass.equals(renewpass)){

                        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Nav_Security.this);
                        alertDialog.setTitle("Thông báo");
                        //alertDialog.setIcon(R.drawable.ic_)
                        alertDialog.setMessage("Mật khẩu nhập lại không khớp mật khẩu mới đã nhập!");

                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        alertDialog.show();



                    }
                    else
                    {
                        if (newpass.length() >= 6)
                        {
                            Albums.password = newpass;
                            finish();
                        }
                        else
                        {
                            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Nav_Security.this);
                            alertDialog.setTitle("Thông báo");
                            //alertDialog.setIcon(R.drawable.ic_)
                            alertDialog.setMessage("Mật khẩu mới cần phải nhiều hơn hoặc bằng 6 ký tự");

                            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                        }

                    }
                }
                else
                {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Nav_Security.this);
                    alertDialog.setTitle("Thông báo");
                    //alertDialog.setIcon(R.drawable.ic_)
                    alertDialog.setMessage("Mật khẩu hiện tại không đúng. Mời nhập lại!");

                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    alertDialog.show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
