# StreamControl
#### Alpha Version *

CRUD com a proposta de catalogar e acompanhar seus gastos mensais de assinaturas de streaming feito com **Spring Boot, JPA, Thymeleaf e MySQL**.

Você cadastra suas assinaturas (Netflix, Spotify, Disney+...) e o sistema mostra o **gasto mensal total**.

> Atividade prática de faculdade: CRUD completo com Spring MVC, Thymeleaf e Spring Data JPA.

## Funcionalidades

- Listar assinaturas
- Cadastrar nova assinatura
- Editar assinatura
- Excluir assinatura
- Ver o gasto mensal total (soma dos valores)
- Validação dos campos com mensagens de erro no formulário

## Tecnologias

- Java 21
- Spring Boot 4.1.2
- Spring Web (MVC)
- Spring Data JPA
- Thymeleaf
- Bean Validation
- MySQL (via XAMPP)
- Maven

## Dados da assinatura

| Campo | Tipo | Regra |
|---|---|---|
| `id` | `Long` | Gerado pelo banco |
| `nomePlataforma` | `String` | Obrigatório, de 2 a 50 caracteres |
| `valorMensal` | `BigDecimal` | Obrigatório, maior que zero |
| `dataAssinatura` | `LocalDate` | Obrigatória, não pode ser no futuro |

## Estrutura do projeto

```
src/main/java/com/marcos/streamcontrol
├── entity        -> Assinatura
├── repository    -> AssinaturaRepository
├── service       -> AssinaturaService
└── controller    -> AssinaturaController

src/main/resources
├── templates/assinaturas  -> lista.html e formulario.html
├── static/css             -> style.css
└── application.properties
```

## Rotas

| Método | Rota | O que faz |
|---|---|---|
| GET | `/assinaturas` | Lista as assinaturas e mostra o total |
| GET | `/assinaturas/novo` | Abre o formulário vazio |
| POST | `/assinaturas/salvar` | Salva (com validação) e redireciona para a lista |
| GET | `/assinaturas/editar/{id}` | Abre o formulário preenchido |
| GET | `/assinaturas/excluir/{id}` | Exclui e volta para a lista |

## Como rodar

### Requisitos

- Java 21
- Maven (ou o `mvnw` que já vem no projeto)
- XAMPP com MySQL

### Passo a passo

1. Abra o **XAMPP** e clique em **Start** no **MySQL** e no **Apache**.
2. Abra o phpMyAdmin em `http://localhost/phpmyadmin`.
3. Crie um banco chamado `streamcontrol`.
4. Clone o projeto:
   ```
   git clone https://github.com/SEU-USUARIO/streamcontrol.git
   cd streamcontrol
   ```
5. Rode a aplicação:
   ```
   mvnw.cmd spring-boot:run        # Windows
   ./mvnw spring-boot:run          # Linux ou Mac
   ```
6. Acesse `http://localhost:8080/assinaturas`.

A tabela `assinaturas` é criada automaticamente pelo Spring (`ddl-auto=update`).

## Configuração do banco

O arquivo `application.properties` usa:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/streamcontrol
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD:}
```

A senha **não fica escrita no código**. Ela é lida da variável de ambiente `DB_PASSWORD`.
O XAMPP vem com o usuário `root` sem senha, então por padrão não é preciso configurar nada.

Se o seu MySQL tem senha, defina a variável antes de rodar:

```
set DB_PASSWORD=sua_senha          # Windows (Command Prompt)
export DB_PASSWORD=sua_senha       # Linux ou Mac
```

## Problemas comuns

- **`Communications link failure`**: o MySQL não está ligado no XAMPP, ou a porta 3306 está ocupada.
- **Página em branco ou 404**: o nome retornado pelo Controller deve ser igual ao caminho do HTML em `templates`.
- **CSS não aparece**: o link deve começar com `/css/...`, sem a palavra `static`.

## Próximos passos

- Busca por plataforma
- Testes com JUnit e Mockito
- API REST reaproveitando o mesmo Service

## Objetivos futuros

- Expansão da proposta do projeto, para adicionar novas funcionalidades
- Versão mobile (Android - APK)

## Agradecimentos

- Obrigado Profº Gean Rocha por todo ensinamento em sala e por seu tempo dedicado a nós alunos.