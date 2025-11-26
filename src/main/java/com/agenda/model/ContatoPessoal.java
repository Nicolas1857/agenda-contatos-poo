package com.agenda.model;

public class ContatoPessoal extends Contato {
    private String dataAniversario;

    public ContatoPessoal(String nome) {
        super(nome);
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CONTATO PESSOAL ===\n");
        sb.append(super.toString());
        
        if (dataAniversario != null && !dataAniversario.isEmpty()) {
            sb.append("Aniversário: ").append(dataAniversario).append("\n");
        }
        
        return sb.toString();
    }
}