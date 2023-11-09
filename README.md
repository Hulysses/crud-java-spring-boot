<h1 align="center"> CRUD com Java e Spring Boot </h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;</a>
</p>

<br>

https://github.com/Hulysses/crud-java-spring-boot/assets/124912812/2e8f1337-a04f-4bb8-a12b-4bb6403e6b56

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java
- Javascript
- HTML
- CSS
- PostgreSQL
- Spring Boot

## 💻 Projeto

O projeto consiste em uma aplicação web que lida com o cadastro de usuários. O sistema realiza operações básicas de CRUD (Create, Read, Update, Delete) em uma entidade de usuário, incluindo validação de dados no frontend e no backend, além de criptografia de senhas antes do armazenamento.

**Frontend:**
1. **HTML (Cadastro) e CSS (Estilo):**
   - Define a estrutura da página de cadastro com campos para nome, e-mail, senha e telefone.
   - Inclui mensagens ocultas para feedback ao usuário, como campos obrigatórios vazios, sucesso no cadastro e erro de e-mail duplicado.

2. **JavaScript (Lógica do Cliente):**
   - Adiciona um listener para o input de telefone, limitando o número de caracteres e removendo caracteres não numéricos.
   - Define duas funções: register para enviar dados de cadastro ao backend e exibir mensagens de feedback, e clean para limpar os campos após o cadastro.

**Backend:**
1. **Java (Model):**
   - Define uma classe User que representa o modelo de dados para os usuários, com campos como id, nome, e-mail, senha e telefone.
   - Usa anotações do Spring, como `@Entity` e `@Table`, para mapear a classe a uma tabela no banco de dados.

2. **Java (Controller):**
   - UserController é o controlador que gerencia as requisições relacionadas aos usuários.
   - Possui métodos para listar usuários, criar, editar, excluir e validar a senha.

3. **Java (Service):**
   - UserService é a camada de serviço que contém lógica de negócios relacionada aos usuários.
   - Usa um repositório, IUser, para acessar o banco de dados.
   - Usa BCryptPasswordEncoder para criptografar senhas antes de armazená-las no banco de dados.
   - Possui métodos para listar, salvar, editar, excluir usuários e validar senhas.

4. **Java (Repository):**
   - IUser é uma interface que estende JpaRepository, fornecendo métodos CRUD para a entidade User.

**Fluxo da Aplicação:**
1. Usuário preenche o formulário de cadastro no frontend e clica em "Cadastrar".
2. O JavaScript valida os campos e envia uma requisição POST para o backend.
3. O backend recebe a requisição, valida os dados usando as anotações de validação e salva o usuário no banco de dados.
4. O backend responde ao frontend com mensagens de sucesso, erro ou validação.
5. O JavaScript exibe mensagens de feedback ao usuário com base na resposta do backend.
