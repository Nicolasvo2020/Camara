package com.example.practica01swfiii;

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

    //DECLARACIÓN DE CONTROLES
    Button btnFoto;
    ImageView ivFoto;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Escucha a los Botones
        btnFoto = (Button) findViewById(R.id.btnFoto);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        //Evento Onclock del Boton btnFoto
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Capturar();
            }
        });
    }
    //cargar el evento captura
        public void Capturar ()
    {
        Toast.makeText(this, "Comenzamos Camara", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);
    }

    //se debe Sobreescribir un metodo que lanza la camara
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)

    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
        {
            Bundle ext = data.getExtras();
            Bitmap bmp = (Bitmap)data.getExtras().get("data");
            ivFoto.setImageBitmap(bmp);
        }
    }

}