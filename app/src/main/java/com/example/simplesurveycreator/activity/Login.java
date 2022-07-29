package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simplesurveycreator.R;

import static com.google.android.material.internal.ContextUtils.getActivity;

public class Login extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        button = (Button) findViewById(R.id.button_signin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

             //   getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new responses()).addToBackStack(null).commit();

                Intent intent = new Intent(Login.this, HomeAppActivity.class);
                startActivity(intent);


                Toast toast_success = Toast.makeText(getApplicationContext(),
            "Successfully Logged in.",
            Toast.LENGTH_SHORT);
                toast_success.show();
            }
        });

    }

//    Toast toast_success = Toast.makeText(getApplicationContext(),
//            "Successfully registered.",
//            Toast.LENGTH_SHORT);

   /* @SuppressLint("ResourceType")
    public void SignInbuttonClickFunction(View view) {
        //Intent intent = new Intent(this, Signup.class);
        //startActivity(intent);



        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new responses()).commit();





    }
   */









    public void FogotPWbuttonClickFunction(View view) {
        Intent intent = new Intent(this, Fogotpw.class);
        startActivity(intent);
    }

    public void SignUpButtonClickFunction(View view) {
        Intent intent = new Intent(this, Signup.class);
       // toast_success.show();
        startActivity(intent);


    }
}