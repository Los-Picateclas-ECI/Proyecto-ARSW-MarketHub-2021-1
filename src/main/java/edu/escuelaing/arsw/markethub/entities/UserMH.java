package edu.escuelaing.arsw.markethub.entities;

public class UserMH {

    private String username;
    private Integer documento;
    private String telefono;
    private String email;
    private String nombre;
    private Integer edad;
    private String password;
    private String direccion;
    private String tipodocumento;
    private Rol role;

    public UserMH() {
        // Contructor vacio
    }

    public UserMH(String username, Integer documento, String telefono, String email, String nombre, Integer edad,
            String password, String direccion, String tipodocumento, Rol role) {
        this.username = username;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
        this.nombre = nombre;
        this.edad = edad;
        this.password = password;
        this.direccion = direccion;
        this.tipodocumento = tipodocumento;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
}
