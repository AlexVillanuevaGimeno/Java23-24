package beans;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + idUsuario + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

