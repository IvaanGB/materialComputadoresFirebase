package materialpc.ivaangb;

/**
 * Created by ivang on 29/5/2018.
 */

public class Computador {

    private String id;
    private int foto;
    private String marca;
    private String tipo;
    private String ram;
    private String so;
    private String color;

    public Computador() {
    }

    public Computador(String id) {
        this.id = id;
    }

    public Computador(String id, int foto, String marca, String tipo, String ram, String so, String color) {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminarComputador(this);
    }



}
