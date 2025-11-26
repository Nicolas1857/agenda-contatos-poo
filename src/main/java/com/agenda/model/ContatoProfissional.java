package com.agenda.model;

public class ContatoProfissional extends Contato {
    private String empresa;
    private String cargo;

    public ContatoProfissional(String nome) {
        super(nome);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CONTATO PROFISSIONAL ===\n");
        sb.append(super.toString());
        
        if (empresa != null && !empresa.isEmpty()) {
            sb.append("Empresa: ").append(empresa).append("\n");
        }
        
        if (cargo != null && !cargo.isEmpty()) {
            sb.append("Cargo: ").append(cargo).append("\n");
        }
        
        return sb.toString();
    }
}