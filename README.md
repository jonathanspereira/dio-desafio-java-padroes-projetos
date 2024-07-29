# BankSystemDIO

## Descrição

O **BankSystemDIO** é uma aplicação de sistema bancário simples que utiliza Spring Boot, Spring Data JPA, OpenFeign e H2 Database. A aplicação permite criar contas bancárias, verificar saldos e realizar transações, utilizando um serviço de validação externo simulado via OpenFeign.

# Ponto Chave e Padrões de Projeto

O projeto BankSystemDIO utiliza diversos padrões de projeto para garantir uma arquitetura limpa, extensível e de fácil manutenção. Alguns dos principais padrões utilizados são:

### Repository Pattern
Utilizado pelo Spring Data JPA para abstrair a camada de acesso a dados. Repositórios são interfaces que permitem operações de CRUD e consultas customizadas.

### Service Layer Pattern
A camada de serviço contém a lógica de negócios da aplicação, separando as regras de negócio das operações de controle e acesso a dados.

### Controller Pattern
Utilizado pelo Spring MVC para lidar com as requisições HTTP e delegar as operações apropriadas para os serviços correspondentes.

### Client Pattern
Implementado com OpenFeign para comunicar-se com serviços externos de forma desacoplada e configurável.

### Event-Driven Architecture
Utilizado para tratar eventos de forma assíncrona, melhorando a escalabilidade e a resposta da aplicação.

Esses padrões ajudam a manter o código organizado, facilitam a implementação de novas funcionalidades e garantem que o sistema seja robusto e escalável.

## Funcionalidades

- Criar contas bancárias (poupança e corrente).
- Verificar o saldo de uma conta.
- Realizar transações (depósitos e saques).
- Validação de transações via serviço externo simulado.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- OpenFeign
- H2 Database

## Pré-requisitos

- JDK 17 ou superior
- Maven
- IDE de sua escolha (Eclipse, IntelliJ IDEA, etc.)

## Configuração do Projeto

1. Clone o repositório para sua máquina local:
    ```bash
    git clone https://github.com/jesimielsilva/dio-padroes-projeto-spring-banco
    ```

2. Abra o projeto em sua IDE (Eclipse, IntelliJ IDEA, etc.).

3. Configure o projeto como um projeto Maven:
    - No Eclipse: `File > Import > Existing Maven Projects`
    - No IntelliJ: `File > Open`, selecione o diretório do projeto e o IntelliJ detectará o Maven automaticamente.

4. Execute a aplicação:
    - Na classe principal `BankSystemApplication`, clique com o botão direito e selecione `Run As > Spring Boot App`.

## Configuração do Banco de Dados H2

O banco de dados H2 é configurado automaticamente. Você pode acessar o console do H2 para visualizar os dados em [http://localhost:8080/h2-console](http://localhost:8080/h2-console) com as seguintes credenciais:
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `sa`
- Password: `password`

## Testando a Aplicação

Você pode usar o Postman, `curl` ou qualquer outra ferramenta de API para testar os endpoints da aplicação.

### Criar uma Conta

**Endpoint**: `POST /api/accounts`

**Exemplo de Requisição**:
```bash
POST "http://localhost:8080/api/accounts?accountId=001&accountType=savings&initialBalance=1000"
```
## Parâmetros:

- **accountId**: ID único da conta.
- **accountType**: Tipo da conta (savings para poupança, checking para corrente).
- **initialBalance**: Saldo inicial da conta.

## Verificar Saldo

**Endpoint**: `GET /api/accounts/{accountId}/balance`

### Exemplo de Requisição:

```bash
GET "http://localhost:8080/api/accounts/001/balance"
```
## Parâmetros:

- **accountId**: ID único da conta.

## Realizar uma Transação

**Endpoint**: `POST /api/accounts/{accountId}/transaction`

### Exemplo de Requisição:

```bash
POST "http://localhost:8080/api/accounts/001/transaction?amount=-200"
```
# Parâmetros:

- **accountId**: ID único da conta.
- **amount**: Valor da transação (positivo para depósito, negativo para saque).

## Estrutura do Projeto

- `one.digitalinnovation.banco`: Pacote raiz da aplicação.
- `.config`: Configurações da aplicação.
- `.model`: Modelos (entidades) da aplicação.
- `.repository`: Repositórios JPA.
- `.service`: Serviços (lógica de negócios).
- `.controller`: Controladores (endpoints REST).
- `.event`: Eventos e ouvintes de eventos.
- `.client`: Clientes Feign para comunicação com serviços externos.

## Criação do Projeto

Este projeto foi criado utilizando o Spring Initializr. Para replicar a criação do projeto, siga os passos abaixo:

1. Acesse [Spring Initializr](https://start.spring.io/).
2. Configure o projeto com as seguintes opções:
   - **Project**: Maven Project
   - **Language**: Java
   - **Spring Boot**: 2.7.x
3. **Project Metadata**:
   - **Group**: one.digitalinnovation.banco
   - **Artifact**: dio-padroes-projeto-spring-banco
   - **Name**: dio-padroes-projeto-spring-banco
   - **Package Name**: one.digitalinnovation.banco.dio-padroes-projeto-spring-banco
   - **Packaging**: Jar
   - **Java**: 17
4. Adicione as dependências:
   - Spring Web
   - Spring Data JPA
   - H2 Database
   - OpenFeign
5. Clique em "Generate" para baixar o projeto.
6. Importe o projeto gerado em sua IDE.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.


