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
import java.time.LocalDateTime;

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
    private LocalDateTime hora_saida;
    private LocalDateTime hora_chegada;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "tb_veiculo", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private VeiculoDTO veiculo;

    @ManyToOne
    @JoinColumn(name = "tb_motoristas", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private MotoristaDTO motorista;

    @Transient
    private Long id_veiculo;

    @Transient
    private Long id_motorista;

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

    public LocalDateTime getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(LocalDateTime hora_saida) {
        this.hora_saida = hora_saida;
    }

    public LocalDateTime getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(LocalDateTime hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public VeiculoDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoDTO veiculo) {
        this.veiculo = veiculo;
        if (veiculo != null) {
            this.id_veiculo = veiculo.getId();
        }
    }

    public MotoristaDTO getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaDTO motorista) {
        this.motorista = motorista;
        if (motorista != null) {
            this.id_motorista = motorista.getId();
        }
    }

    @JsonProperty("id_veiculo")
    public Long getId_veiculo() {
        return veiculo != null ? veiculo.getId() : id_veiculo;
    }

    @JsonProperty("id_veiculo")
    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    @JsonProperty("id_motorista")
    public Long getId_motorista() {
        return motorista != null ? motorista.getId() : id_motorista;
    }

    @JsonProperty("id_motorista")
    public void setId_motorista(Long id_motorista) {
        this.id_motorista = id_motorista;
    }

    // Campos derivados só de leitura, para facilitar a exibição no frontend
    // (evita expor as entidades inteiras de veiculo/motorista, com dados sensíveis aninhados)

    @JsonProperty("veiculo_placa")
    public String getVeiculoPlaca() {
        return veiculo != null ? veiculo.getPlaca() : null;
    }

    @JsonProperty("veiculo_modelo")
    public String getVeiculoModelo() {
        return veiculo != null ? veiculo.getModelo() : null;
    }

    @JsonProperty("motorista_nome")
    public String getMotoristaNome() {
        return motorista != null ? motorista.getNome() : null;
    }
}
