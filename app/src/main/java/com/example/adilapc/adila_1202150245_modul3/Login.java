package com.example.adilapc.adila_1202150245_modul3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button a, b;
    private EditText c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        a= (Button)findViewById(R.id.ok);
        b =(Button)findViewById(R.id.cancel);
        c = (EditText) findViewById(R.id.username);
        d = (EditText) findViewById(R.id.password);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setText("");
                b.setText("");
            }
        });
    }
    public void oke(View view) {
        final String user = c.getText().toString();
        String pass = d.getText().toString();

        if ((user.equals("EAD") && pass.equals("MOBILE")) ||(user.equals("EAD") && pass.equals("MOBILE"))){
            Toast.makeText(this,"Anda berhasil login",Toast.LENGTH_LONG).show();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Alert Message");

            alert.setMessage("Login Success")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent d = new Intent(Login.this,MainActivity.class);
                            d.putExtra("username",user);
                            startActivity(d);
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();



        }
        else if (user.isEmpty() && pass.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Isi dulu bro");

            alert.setMessage("Login Failed")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();

        }
        else if (!user.equals("EAD")  && !pass.equals("MOBILE")|| !user.equals("EAD")  && !pass.equals("MOBILE")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("BUKAN AKUN ANDA");

            alert.setMessage("Login Failed")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();
        }}
}
