package materialpc.ivaangb;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ivang on 29/5/2018.
 */

public class Datos {
    private static String db = "thePC";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Computador> pcs = new ArrayList<>();

    public static void guardar(Computador p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public static ArrayList<Computador> obtener(){
        return pcs;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setComputador(ArrayList<Computador> pc){
        Datos.pcs = pc;
    }

    public static void eliminarComputador(Computador pc){
        databaseReference.child(db).child(pc.getId()).removeValue();
    }

    public static void modificarComputador(Computador p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

}
