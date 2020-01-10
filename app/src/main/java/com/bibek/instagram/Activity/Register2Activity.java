package com.bibek.instagram.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bibek.instagram.LoginApi;
import com.bibek.instagram.R;
import com.bibek.instagram.Url;
import com.bibek.instagram.Model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register2Activity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etUsername, etPassword;
    public static int phoneOrEmail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        btnRegister = findViewById(R.id.btnRegII);
        etUsername = findViewById(R.id.etUsernameRegII);
        etPassword = findViewById(R.id.etPasswordRegII);

        Bundle bundle = getIntent().getExtras();
        final String phone = bundle.getString("regWithPhone");
        final String email = bundle.getString("regWithEmail");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userRegister;

                if(phoneOrEmail == 1)
                {
                    userRegister = new UserModel(phone, etUsername.getText().toString(), etPassword.getText().toString());

                }
                else{
                    userRegister = new UserModel(email, etUsername.getText().toString(), etPassword.getText().toString());
                }

                LoginApi apiForRegister = Url.getInstance().create(LoginApi.class);
                Call<Void> registerCall =apiForRegister.register(userRegister);

                registerCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(Register2Activity.this, "Code: " +response.body(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent signUpComplete = new Intent(Register2Activity.this, LoginActivity.class);
                        startActivity(signUpComplete);
                        //Further process here if successfully got the phone number
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Register2Activity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }
}
