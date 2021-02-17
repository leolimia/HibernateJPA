package hibernateJPA.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

//para que JPA me reconozca esto como entidad lo anoto como Entity
@Entity
@Table(name = "EMPLEADO") // quiero que me lo guardes en una tabla
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //JPA ME OBLIGA A QUE TODAS LAS ENTIDADES TENGAN UN IDENTIFICAADDOR QUE SE LO DOI CON ID
    @Column (name = "COL_EMPLEADO" )
    private Long codigo;

    @Column (name = "COL_APELLIDOS" )
    private String apellidos;

    @Column (name = "COL_NOMBRE" )
    private String nombre;

    @Column (name = "COL_FECHA_NACIMIENTO" )
    private Date fechaNacimiento;

    //constructor vacio para Hibernate
    public Empleado(){
}

    public Empleado(Long codigo, String apellidos, String nombre, Date fechaNacimiento) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    //me permite haacer una impresion rapida por pantalla para controlar
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
