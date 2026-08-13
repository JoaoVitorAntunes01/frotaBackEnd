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
@Table(name = "tb_motoristas")
public class MotoristaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;

    @Transient
    private String email;

    @Transient
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tb_usuarios", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private UsuarioDTO id_usuario;

    @ManyToOne
    @JoinColumn(name = "tb_empresa", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private EmpresaDTO empresa;

    @Transient
    private Long id_empresa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public UsuarioDTO getId_usuario() { return id_usuario; }
    public void setId_usuario(UsuarioDTO id_usuario) { this.id_usuario = id_usuario; }

    public EmpresaDTO getEmpresa() { return empresa; }
    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
        if (empresa != null) {
            this.id_empresa = empresa.getId();
        }
    }

    @JsonProperty("id_empresa")
    public Long getId_empresa() {
        return empresa != null ? empresa.getId() : id_empresa;
    }

    @JsonProperty("id_empresa")
    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }
}
