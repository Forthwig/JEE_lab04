package junia.lab04.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingenieur extends GenericEntity{

    private String login;

    private String password;

    private String role;

    public Ingenieur() {
    }

    public Ingenieur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingenieur ingenieur = (Ingenieur) o;
        return Objects.equals(login, ingenieur.login) && Objects.equals(password, ingenieur.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
