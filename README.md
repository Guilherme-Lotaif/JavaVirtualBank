# Java Virtual Bank

Este é um projeto de sistema bancário virtual em Java, projetado para fornecer funcionalidades essenciais para operações bancárias.

## Funcionalidades

### 1. Abrir Conta
O usuário insere os dados do futuro correntista na aplicação. Se o futuro correntista não tiver uma conta aberta, o sistema abrirá a conta, inserindo os dados do correntista em uma lista linear duplamente encadeada. O sistema não permite o registro de dois correntistas com o mesmo número de CPF.

### 2. Realizar Saque
O usuário fornece o valor desejado para saque. Se o saldo disponível for suficiente, o sistema debitará o valor do saldo do correntista. A pesquisa é feita pelo número de CPF do correntista.

### 3. Realizar Depósito
O usuário fornece o valor desejado para saque. Se estiver cadastrado no sistema, o valor é adicionado ao seu saldo. A pesquisa é realizada pelo número de CPF do correntista.

### 4. Relatório de Contas
Gera um relatório detalhado de todas as contas no sistema, incluindo informações como CPF da conta, titular, saldo.

### 5. Encerrar Conta
Permite que um usuário encerre sua conta bancária.

## Requisitos do Sistema
- Java JDK 8 ou superior
- Ambiente de desenvolvimento integrado (IDE) compatível com Java (Eclipse, IntelliJ, etc.)

## Como Executar o Projeto
1. Clone este repositório: `git clone https://github.com/GuilhermeLotaif01/JavaVirtualBank.git`
2. Abra o projeto em sua IDE Java preferida.
3. Compile e execute o arquivo principal do programa.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para reportar problemas, propor melhorias ou enviar pull requests.
