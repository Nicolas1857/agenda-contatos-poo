package com.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class Contato {
    private String nome;
    private List<String> telefones;
    private List<String> emails;
    private Endereco endereco;

    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public void adicionarTelefone(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            this.telefones.add(telefone);
        }
    }

    public void adicionarEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.emails.add(email);
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        
        if (!telefones.isEmpty()) {
            sb.append("Telefones: ").append(String.join(", ", telefones)).append("\n");
        }
        
        if (!emails.isEmpty()) {
            sb.append("E-mails: ").append(String.join(", ", emails)).append("\n");
        }
        
        if (endereco != null) {
            sb.append("Endereço: ").append(endereco).append("\n");
        }
        
        return sb.toString();
    }
}