package com.agenda;

import com.agenda.model.*;
import com.agenda.service.Agenda;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        System.out.println("=== AGENDA DE CONTATOS ===\n");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);
        
        System.out.println("\nEncerrando aplicação...");
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Adicionar Contato Pessoal");
        System.out.println("2. Adicionar Contato Profissional");
        System.out.println("3. Listar Todos os Contatos");
        System.out.println("4. Buscar Contato");
        System.out.println("5. Editar Contato");
        System.out.println("6. Remover Contato");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarContatoPessoal();
                break;
            case 2:
                adicionarContatoProfissional();
                break;
            case 3:
                listarContatos();
                break;
            case 4:
                buscarContato();
                break;
            case 5:
                editarContato();
                break;
            case 6:
                removerContato();
                break;
            case 0:
                break;
            default:
                System.out.println("\nOpção inválida!");
        }
    }

    private static void adicionarContatoPessoal() {
        System.out.println("\n--- ADICIONAR CONTATO PESSOAL ---");
        
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        
        ContatoPessoal contato = new ContatoPessoal(nome);
        
        adicionarTelefonesEmails(contato);
        adicionarEndereco(contato);
        
        System.out.print("Data de aniversário (dd/mm/aaaa): ");
        String dataAniversario = scanner.nextLine();
        contato.setDataAniversario(dataAniversario);
        
        agenda.adicionarContato(contato);
        System.out.println("\n✓ Contato pessoal adicionado com sucesso!");
    }

    private static void adicionarContatoProfissional() {
        System.out.println("\n--- ADICIONAR CONTATO PROFISSIONAL ---");
        
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        
        ContatoProfissional contato = new ContatoProfissional(nome);
        
        adicionarTelefonesEmails(contato);
        adicionarEndereco(contato);
        
        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();
        contato.setEmpresa(empresa);
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        contato.setCargo(cargo);
        
        agenda.adicionarContato(contato);
        System.out.println("\n✓ Contato profissional adicionado com sucesso!");
    }

    private static void adicionarTelefonesEmails(Contato contato) {
        System.out.print("Quantos telefones deseja adicionar? ");
        int qtdTel = lerOpcao();
        for (int i = 0; i < qtdTel; i++) {
            System.out.print("Telefone " + (i + 1) + ": ");
            contato.adicionarTelefone(scanner.nextLine());
        }
        
        System.out.print("Quantos e-mails deseja adicionar? ");
        int qtdEmail = lerOpcao();
        for (int i = 0; i < qtdEmail; i++) {
            System.out.print("E-mail " + (i + 1) + ": ");
            contato.adicionarEmail(scanner.nextLine());
        }
    }

    private static void adicionarEndereco(Contato contato) {
        System.out.print("Deseja adicionar endereço? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Estado: ");
            String estado = scanner.nextLine();
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            
            contato.setEndereco(new Endereco(rua, cidade, estado, cep));
        }
    }

    private static void listarContatos() {
        System.out.println("\n--- LISTA DE CONTATOS ---");
        agenda.listarTodos();
    }

    private static void buscarContato() {
        System.out.println("\n--- BUSCAR CONTATO ---");
        System.out.print("Digite o nome ou e-mail: ");
        String termo = scanner.nextLine();
        
        Contato contato = agenda.buscarPorNome(termo);
        if (contato != null) {
            System.out.println("\n" + contato);
        } else {
            System.out.println("\nContato não encontrado!");
        }
    }

    private static void editarContato() {
        System.out.println("\n--- EDITAR CONTATO ---");
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        
        if (agenda.editarContato(nome)) {
            System.out.println("\n✓ Contato editado com sucesso!");
        } else {
            System.out.println("\nContato não encontrado!");
        }
    }

    private static void removerContato() {
        System.out.println("\n--- REMOVER CONTATO ---");
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        
        if (agenda.removerContato(nome)) {
            System.out.println("\n✓ Contato removido com sucesso!");
        } else {
            System.out.println("\nContato não encontrado!");
        }
    }
}