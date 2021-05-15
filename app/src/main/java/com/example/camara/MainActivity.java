package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFoto;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFoto= (Button) findViewById(R.id.btnFoto);
        foto=(ImageView) findViewById(R.id.ivCamara);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Capturar(foto);
            }
        });
    }
    public void Capturar(View view) {
        Toast.makeText(this,"Comenzando camara",Toast.LENGTH_SHORT).show();
        Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            Bitmap bmp =(Bitmap)data.getExtras().get("data");
            foto.setImageBitmap(bmp);
        }
    }
}