package com.agenda.service;

import com.agenda.model.Contato;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (contato != null && contato.getNome() != null && !contato.getNome().trim().isEmpty()) {
            contatos.add(contato);
        } else {
            System.out.println("Erro: Contato inválido!");
        }
    }

    public boolean removerContato(String nome) {
        Contato contato = buscarPorNome(nome);
        if (contato != null) {
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Contato buscarPorNome(String termo) {
        for (Contato contato : contatos) {
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase())) {
                return contato;
            }
            
            for (String email : contato.getEmails()) {
                if (email.toLowerCase().contains(termo.toLowerCase())) {
                    return contato;
                }
            }
        }
        return null;
    }

    public void listarTodos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        
        System.out.println("Total de contatos: " + contatos.size() + "\n");
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Contato #" + (i + 1));
            System.out.println(contatos.get(i));
            System.out.println("------------------------");
        }
    }

    public boolean editarContato(String nome) {
        Contato contato = buscarPorNome(nome);
        if (contato != null) {
            System.out.println("\nContato encontrado:");
            System.out.println(contato);
            System.out.println("Funcionalidade de edição disponível.");
            return true;
        }
        return false;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}