package com.main.projeto_final.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table (name = "tb_empresa")
public class EmpresaDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String nome;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "tb_usuarios", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private UsuarioDTO usuario;

    @Transient
    private Long id_usuario;

    // Usados apenas no cadastro (criação do usuário vinculado); não são persistidos diretamente.
    @Transient
    private String email;

    @Transient
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
        if (usuario != null) {
            this.id_usuario = usuario.getId();
        }
    }

    @JsonProperty("id_usuario")
    public Long getId_usuario() {
        return usuario != null ? usuario.getId() : id_usuario;
    }

    @JsonProperty("id_usuario")
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
