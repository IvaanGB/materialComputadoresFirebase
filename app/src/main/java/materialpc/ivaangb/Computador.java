package materialpc.ivaangb;

/**
 * Created by ivang on 29/5/2018.
 */

public class Computador {

    private String id;
    private int foto;
    private int marca;
    private int tipo;
    private String ram;
    private int so;
    private int color;

    public Computador() {
    }

    public Computador(String id) {
        this.id = id;
    }

    public Computador(String id, int foto, int marca, int tipo, String ram, int so, int color) {
        this.id = id;
        this.foto = foto;
        this.marca = marca;
        this.tipo = tipo;
        this.ram = ram;
        this.so = so;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }



}
