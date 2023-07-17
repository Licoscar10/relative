package com.example.relative;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.example.relative.databinding.ActivityDetallesBinding;


public class detalles extends AppCompatActivity {
  ActivityDetallesBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind=ActivityDetallesBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Bundle extras=getIntent().getExtras();
        String nombre=extras.getString("nombreProducto");
        String Caracteristica=extras.getString("descrip");
        Bitmap fotograf=extras.getParcelable("fototoma");
        float califi=extras.getFloat("calificacion");

        bind.productofin.setText(nombre);
        bind.carfin.setText(Caracteristica);
        bind.fotofin.setImageBitmap(fotograf);
        bind.progresfin.setRating(califi);

        Toast.makeText(this,"deta", Toast.LENGTH_SHORT).show();


    }
}