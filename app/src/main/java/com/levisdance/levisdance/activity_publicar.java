package com.levisdance.levisdance;

        import android.content.Intent;
        import android.icu.text.DateFormat;
        import android.icu.text.SimpleDateFormat;
        import android.os.Build;
        import android.support.annotation.RequiresApi;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.levisdance.levisdance.Control.LogicDataBase;
        import com.levisdance.levisdance.Modelo.*;
        import com.levisdance.levisdance.Modelo.Publicacion;

        import java.util.Date;

public class activity_publicar extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.levisdance.levisdance.MESSAGE";

    private com.levisdance.levisdance.Modelo.Publicacion publicacion;
    private LogicDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void agregarPublicacion(View view){
        EditText titulo= (EditText) findViewById(R.id.titulo);
        String title= titulo.getText().toString();
        EditText lugar= (EditText) findViewById(R.id.lugar);
        String location= lugar.getText().toString();


        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        Date fecha = new Date();

        //no se si me falte algún otro elemento

        if(!titulo.getText().toString().equals("")&&!lugar.getText().toString().equals("")){
            //Aquí se agrega a la base de datos como hicimos con usuario
            publicacion=new Publicacion(titulo.getText().toString(),
                    fecha, lugar.getText().toString(),null);

            Intent intent=new Intent();
            String correo=intent.getStringExtra(EXTRA_MESSAGE); //se pasa el correo para poder agregar publicacion
        }else{
            Toast.makeText(this, "Todos los campos deben estar completos", Toast.LENGTH_SHORT).show();
            titulo.setText("");
            lugar.setText("");
        }
    }

    public void abrirImagen() {
        //hola mundo

        try {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivity(intent);
        }catch (Exception e){
            Log.i("Error", e.toString());
        }
    }
}