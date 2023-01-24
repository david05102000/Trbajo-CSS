package ap;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Asignatura {
    @Id
    @Column(name = "codigo")
    private Integer codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "codCiclo")
    private Integer codCiclo;

    public Asignatura() {
    }

    public Asignatura(Integer codigo, String nombre, Integer codCiclo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codCiclo = codCiclo;
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

    public Integer getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(Integer codCiclo) {
        this.codCiclo = codCiclo;
    }
}
