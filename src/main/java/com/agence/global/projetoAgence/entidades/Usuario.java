package com.agence.global.projetoAgence.entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String nome;
    private String senha;

    /*um usuario pode ter muitos*/
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_role"
            , uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "role_id"}
            , name = "unique_role_user")
            , joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario"
            , foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT))
            , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role"
            , foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))//constraint
    private List<Role> roles; /*OS papeis dos acessos*/

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
