package edu.escuelaing.arsw.markethub.entities;

public class UserMH {

    private String username;
    private Integer documento;
    private String telefono;
    private String email;
    private String password;
    private String direccion;
    private String tipoDocumento;
    private String role;

    public UserMH() {
        //Contructor vacio
    }

    public UserMH(String username, Integer documento, String telefono, String email, String password, String direccion, String tipoDocumento, String role) {
        this.username = username;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.tipoDocumento = tipoDocumento;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
