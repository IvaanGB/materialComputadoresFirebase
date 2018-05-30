package materialpc.ivaangb;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputadores extends AppCompatActivity {
    private Spinner cmbMarca;
    private Spinner cmbTipo;
    private EditText txtRam;
    private Spinner cmbSO;
    private Spinner cmbColor;
    private ArrayList<Integer> fotos;
    private ArrayAdapter<String> adMarca, adTipo, adSO, adColor;
    private String opMarca[], opTipo[], opSO[], opColor[];
    private String errorSpinner, errorRam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadores);

        errorSpinner = getResources().getString(R.string.errorS);
        errorRam = getResources().getString(R.string.errorCantidad);

        cmbMarca = findViewById(R.id.cmbMarca);
        cmbTipo = findViewById(R.id.cmbTipo);
        txtRam = findViewById(R.id.txtRAM);
        cmbSO = findViewById(R.id.cmbSO);
        cmbColor = findViewById(R.id.cmbColor);

        opMarca = this.getResources().getStringArray(R.array.spnMarca);
        adMarca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opMarca);
        cmbMarca.setAdapter(adMarca);

        opTipo = this.getResources().getStringArray(R.array.spnTipo);
        adTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opTipo);
        cmbTipo.setAdapter(adTipo);

        opSO = this.getResources().getStringArray(R.array.spnSisOP);
        adSO = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opSO);
        cmbSO.setAdapter(adSO);

        opColor = this.getResources().getStringArray(R.array.spnColor);
        adColor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opColor);
        cmbColor.setAdapter(adColor);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public boolean validar(){
        if (!metodos.validarSpinner(cmbMarca, errorSpinner)){
            return false;
        }

        if (!metodos.validarSpinner(cmbTipo, errorSpinner)){
            return false;
        }

        if(txtRam.getText().toString().isEmpty() || Integer.parseInt(txtRam.getText().toString())==0){
            txtRam.requestFocus();
            txtRam.setError(errorRam);
            return false;
        }

        if (!metodos.validarSpinner(cmbSO, errorSpinner)){
            return false;
        }

        if (!metodos.validarSpinner(cmbColor, errorSpinner)){
            return false;
        }
        return true;
    }

    public void guardar(View v){
        String id;
        int foto;
        String marca;
        String tipo;
        String ram;
        String sisOp;
        String color;

        id = Datos.getId();
        foto = Datos.fotoAleatoria(fotos);
        marca = cmbMarca.getSelectedItem().toString();
        tipo = cmbTipo.getSelectedItem().toString();
        ram = txtRam.getText().toString();
        sisOp = cmbSO.getSelectedItem().toString();
        color = cmbColor.getSelectedItem().toString();

        if (validar()){
            Computador pc = new Computador(id, foto, marca, tipo, ram, sisOp, color);
            pc.guardar();
            Snackbar.make(v, getResources().getString(R.string.mensaje_guardado_exitoso), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
            limpiar();
        }

    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cmbMarca.setSelection(0);
        cmbTipo.setSelection(0);
        txtRam.setText("");
        cmbSO.setSelection(0);
        cmbColor.setSelection(0);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearComputadores.
                this,Principal.class);
        startActivity(i);
    }

}
