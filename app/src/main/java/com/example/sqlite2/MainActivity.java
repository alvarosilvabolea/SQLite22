package com.example.sqlite2;



import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqlite2.R;

public class MainActivity extends AppCompatActivity {

    EditText txtCodigo, txtNombre;
    TextView txtResultado;
    Button btnInsertar, btnActualizar, btnEliminar, btnConsultar;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtCodigo = (EditText)findViewById(R.id.txtReg);
        txtNombre = (EditText)findViewById(R.id.txtVal);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnConsultar = (Button)findViewById(R.id.btnConsultar);

        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuario",null,1);
        db = usdbh.getWritableDatabase();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();


                String sql ="INSERT INTO Usuarios (codigo, nombre) VALUES('"+cod+"', '"+nom+"')";
                db.execSQL(sql);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();


                String sql ="UPDATE Usuarios SET nombre ='"+nom+"' WHERE codigo = '"+cod+"'"";
                db.execSQL(sql);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();


                String sql ="DELETE FROM Usuarios WHERE codigo = '"+cod+"' ";
                db.execSQL(sql);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT codigo, NOMBRE from USuarios", null);

            }
        });
    }
}