package modelo;

public class Login {

    private int usuario;
    private int senha;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Login() {
    }

    public Login(int usuario, int senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String toString() {
        return "\n Dados do Login:"
                + "\n Usuário:" + getUsuario()
                + "\n Senha:" + getSenha();
    }

}
