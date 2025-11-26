# Agenda de Contatos - POO em Java

## 📋 Descrição
Projeto acadêmico de uma Agenda de Contatos desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos.

## 🎯 Conceitos de POO Aplicados
- ✅ Classes e Objetos
- ✅ Encapsulamento (atributos privados com getters/setters)
- ✅ Herança (ContatoPessoal e ContatoProfissional herdam de Contato)
- ✅ Polimorfismo (sobrescrita do método toString())
- ✅ Composição (Contato possui Endereco)
- ✅ Agregação (Agenda possui List<Contato>)

## 📁 Estrutura do Projeto
```
AgendaContatos/
├── src/main/java/com/agenda/
│   ├── Main.java
│   ├── model/
│   │   ├── Contato.java
│   │   ├── ContatoPessoal.java
│   │   ├── ContatoProfissional.java
│   │   └── Endereco.java
│   └── service/
│       └── Agenda.java
```

## 🚀 Como Executar

### No IntelliJ IDEA:
1. Abra o IntelliJ IDEA
2. File → Open → Selecione a pasta "AgendaContatos"
3. Aguarde o IntelliJ indexar o projeto
4. Localize a classe `Main.java`
5. Clique com botão direito → Run 'Main.main()'

### Via Terminal:
```bash
cd AgendaContatos/src/main/java
javac com/agenda/Main.java com/agenda/model/*.java com/agenda/service/*.java
java com.agenda.Main
```

## 📝 Funcionalidades
- ✅ Adicionar contatos (Pessoal e Profissional)
- ✅ Listar todos os contatos
- ✅ Buscar contato por nome ou e-mail
- ✅ Editar dados de contato
- ✅ Remover contato
- ✅ Armazenamento em memória com ArrayList

## 👥 Autores
[Seu Nome e dos membros do grupo]

## 📅 Data de Entrega
26/06/2025

## 📄 Licença
Projeto acadêmico - Programação Orientada a Objetos
