package ap;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ciclo {

    @Id
    @Column(name = "codigo")
    private Integer codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;


    public Ciclo() {
    }

    public Ciclo(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;

    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

