package com.example.relative;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.example.relative.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
Bitmap fototomada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Theme_Relative);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.guarda.setOnClickListener(v ->{
            operar();
        });

        binding.foto.setOnClickListener(V ->{

            abrircamara();
        });
    }
    private void operar()
    {

        if(binding.nombre.getText().toString().intern()!=""&&binding.caracte.getText().toString().intern()!="")
        {
            String nombrefinal = binding.nombre.getText().toString();
            String carac = binding.caracte.getText().toString();
            String prese=binding.presentacion.getText().toString();
            Bitmap fotofinal = fototomada;
            float califi = binding.proce.getRating();

            Intent abre = new Intent(this, detalles.class);
            abre.putExtra("fototoma", fotofinal);
            abre.putExtra("prese",prese);
            abre.putExtra("nombreProducto", nombrefinal);
            abre.putExtra("calificacion", califi);
            abre.putExtra("descrip", carac);

            startActivity(abre);
        }

        else
        {
            Toast.makeText(this,"diligencie datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void abrircamara(){

        Intent camara=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camara, 11);
    }
    protected void onActivityResult(int RequestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(RequestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK && RequestCode==11){
            if(data!=null){
                fototomada =data.getExtras().getParcelable("data");
                binding.foto.setImageBitmap(fototomada);


            }

        }
        else{
            Toast.makeText(this,"No Tomada", Toast.LENGTH_SHORT).show();
        }
    }
}