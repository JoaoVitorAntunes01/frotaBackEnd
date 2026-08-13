/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.projeto_final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table (name = "tb_rotas")
public class RotasDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String cep_saida;
    private String cep_destino;
    private String distancia;
    private String tempo_estimado;
    private Timestamp hora_saida;
    private Timestamp hora_chegada;
    private String observacao;
    
    @OneToOne
    @JoinColumn(name = "tb_veiculo", referencedColumnName = "id", nullable = false)
    private VeiculoDTO id_veiculo;
            
    @OneToOne
    @JoinColumn(name = "tb_motoristas", referencedColumnName = "id", nullable = false)
    private MotoristaDTO id_motorista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep_saida() {
        return cep_saida;
    }

    public void setCep_saida(String cep_saida) {
        this.cep_saida = cep_saida;
    }

    public String getCep_destino() {
        return cep_destino;
    }

    public void setCep_destino(String cep_destino) {
        this.cep_destino = cep_destino;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTempo_estimado() {
        return tempo_estimado;
    }

    public void setTempo_estimado(String tempo_estimado) {
        this.tempo_estimado = tempo_estimado;
    }

    public Timestamp getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Timestamp hora_saida) {
        this.hora_saida = hora_saida;
    }

    public Timestamp getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(Timestamp hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public VeiculoDTO getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(VeiculoDTO id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public MotoristaDTO getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(MotoristaDTO id_motorista) {
        this.id_motorista = id_motorista;
    }
    
}
