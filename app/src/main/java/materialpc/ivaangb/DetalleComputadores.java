package materialpc.ivaangb;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputadores extends AppCompatActivity {

    private String id;
    private ImageView fot;
    private TextView txtMarcaDetalle;
    private TextView txtTipoDetalle;
    private TextView txtRAMDetalle;
    private TextView txtSODetalle;
    private TextView txtColorDetalle;
    private String[] selMarca, selTipo, selSO, selColor;
    private String ram;
    private int foto, marca, tipo, so, color;
    private Intent i;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computadores);

        txtMarcaDetalle = findViewById(R.id.txtMarcaDetalle);
        txtTipoDetalle = findViewById(R.id.txtTipoDetalle);
        txtRAMDetalle = findViewById(R.id.txtRAMDetalle);
        txtSODetalle = findViewById(R.id.txtSODetalle);
        txtColorDetalle = findViewById(R.id.txtColorDetalle);
        fot = findViewById(R.id.foto);

        selMarca = getResources().getStringArray(R.array.spnMarca);
        selTipo = getResources().getStringArray(R.array.spnTipo);
        selSO = getResources().getStringArray(R.array.spnSisOP);
        selColor = getResources().getStringArray(R.array.spnColor);

        i = getIntent();

        bundle = i.getBundleExtra("datos");
        id = bundle.getString("id");
        foto = bundle.getInt("foto");
        marca = bundle.getInt("marca");
        tipo = bundle.getInt("tipo");
        ram = bundle.getString("ram");
        so = bundle.getInt("so");
        color = bundle.getInt("color");

        fot.setImageResource(foto);
        txtMarcaDetalle.setText(selMarca[marca]);
        txtTipoDetalle.setText(selTipo[tipo]);
        txtRAMDetalle.setText(ram);
        txtSODetalle.setText(selSO[so]);
        txtColorDetalle.setText(selColor[color]);
    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador pc = new Computador(id);
                pc.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetalleComputadores.this,Principal.class);
        startActivity(i);
    }


}
