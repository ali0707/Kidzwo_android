package com.example.ghassen.finag;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ghassen.finag.Entities.Connexion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    String url;
    RequestQueue queue ;
    ImageView imageView;
    Button pickImage;
    Activity mActivity;

    private Bitmap bitmap;
    private String KEY_IMAGE = "image";
    private String KEY_NAME = "name";

    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        pickImage= findViewById(R.id.pickImgaeButton);
        imageView = findViewById(R.id.previewImage);

        final EditText login = findViewById(R.id.login);
        //final EditText mail = findViewById(R.id.mail);
        final EditText nom = findViewById(R.id.nom);
        final EditText psw = findViewById(R.id.password);


        Button SignUp = findViewById(R.id.SignUp);

        queue = Volley.newRequestQueue(this);




        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = Connexion.url+"register/user/";
              //  + "/" + mail.getText()
                url += login.getText() + "/" + psw.getText()+ "/" + nom.getText();
                StringRequest getData = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getInt("success") == 1) {
                                Intent signIn = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(signIn);
                            } else
                                Toast.makeText(getApplicationContext(), "non", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Log.e("JSONExeption", e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ErrorResponse", "aaaaa"+error.getMessage());
                    }
                });
                queue.add(getData);
            }
        });


        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }


    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
}
