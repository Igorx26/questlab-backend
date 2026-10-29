# QuestLab API

API RESTful desenvolvida em **Java 21** e **Spring Boot 3** para o gerenciamento de **questões de concursos públicos**, provas, bancas examinadoras, instituições, cargos, disciplinas, assuntos e acompanhamento de desempenho de estudantes por meio de relatórios analíticos.

---

## Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework Principal:** Spring Boot 3.5.6
  - **Spring Web:** Construção de endpoints RESTful.
  - **Spring Data JPA / Hibernate:** Persistência de dados, consultas customizadas e projeções.
  - **Spring Validation (Jakarta Bean Validation):** Validação de dados de entrada (`@Valid`, `@NotBlank`, `@Email`, `@CPF`, `@CNPJ`, `@Past`, etc.).
- **Bancos de Dados:**
  - **H2 Database:** Banco em memória para ambiente de desenvolvimento e testes rápidos (com carga inicial automática via `data.sql`).
  - **Microsoft SQL Server:** Banco de dados relacional configurado para o perfil de produção.
- **Mapeamento de Objetos:** ModelMapper 3.0.0
- **Documentação da API:** SpringDoc OpenAPI 2.8.14 (Swagger UI)
- **Produtividade:** Project Lombok
- **Gerenciador de Dependências e Build:** Apache Maven (com suporte a Maven Wrapper)

---

## Arquitetura do Projeto

A aplicação segue o padrão de **Arquitetura em Camadas (Layered Architecture)**, garantindo a separação de responsabilidades, facilidade de manutenção e testabilidade:

1. **Controller Layer (`rest.controller`):** Recebe as requisições HTTP, valida os payloads de entrada e retorna os códigos de status HTTP apropriados junto aos DTOs.
2. **DTO Layer (`rest.dto`):** Objetos de Transferência de Dados utilizados para expor apenas as informações necessárias nas respostas da API, incluindo estruturas específicas para relatórios.
3. **Service Layer (`service`):** Concentra as regras de negócio, validações de integridade, controle de acesso por perfil de usuário (`ADMIN`, `PROFESSOR`, `ALUNO`), cálculos estatísticos e conversão entre Models e DTOs.
4. **Repository Layer (`repository` e `repository.projection`):** Interfaces que estendem `JpaRepository` do Spring Data JPA para operações CRUD e consultas customizadas com **Projections** otimizadas para agregação de relatórios.
5. **Model Layer (`model`):** Entidades JPA mapeadas para as tabelas do banco de dados, contendo anotações de validação de domínio.
6. **Exception Handling (`exception`):** Tratamento global e centralizado de erros utilizando `@ControllerAdvice`, retornando respostas padronizadas.

### Estrutura de Pacotes

```text
src/main/java/br/com/dbug/questlab
├── config/                  # Configurações de Beans (Swagger/OpenAPI e ModelMapper)
├── exception/               # Exceções customizadas e Handler global (@ControllerAdvice)
├── model/                   # Entidades JPA mapeadas para o banco de dados
├── repository/              # Repositórios Spring Data JPA
│   └── projection/          # Interfaces de projeção para consultas agregadas e relatórios
├── rest/
│   ├── controller/          # Controladores REST (Endpoints da API)
│   └── dto/                 # Data Transfer Objects (Entidades e Relatórios)
├── service/                 # Camada de regras de negócio e serviços
└── QuestLabApplication.java # Classe principal de inicialização do Spring Boot
```

### Modelo de Domínio

O domínio do sistema conecta o ecossistema de concursos públicos à resolução de questões pelos usuários:

- **Instituição (`instituicao`)** e **Banca (`banca`)** organizam um **Concurso (`concurso`)**.
- Um **Concurso (`concurso`)** e um **Cargo (`cargo`)** compõem uma **Prova (`prova`)**.
- Uma **Disciplina (`disciplina`)** agrupa diversos **Assuntos (`assunto`)**.
- Uma **Questão (`questao`)** pertence a uma **Prova** e a um **Assunto**, possuindo múltiplas **Alternativas (`alternativa`)**.
- O **Usuário (`usuario`)** (com perfil `ADMIN`, `PROFESSOR` ou `ALUNO`) registra suas respostas em **Usuário Resposta (`usuarioResposta`)**, vinculando o usuário, a questão e a alternativa escolhida.

---

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado em sua máquina:

- **Java JDK 21** ou superior (verifique com `java -version`).
- **Apache Maven 3.9+** (opcional, pois o projeto já inclui o **Maven Wrapper** `mvnw` / `mvnw.cmd`).
- **SQL Server** (opcional, necessário apenas se desejar rodar com o perfil `producao`).

---

## Como Rodar a Aplicação

### 1. Clonar o Repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd questlab
```

### 2. Ambiente de Desenvolvimento (Padrão - H2 Database)

Por padrão, o arquivo `application.properties` está configurado com o perfil `desenvolvimento` ativo (`spring.profiles.active=desenvolvimento`). Nesse modo:
- O banco de dados **H2 em memória** é iniciado automaticamente.
- As tabelas são geradas pelo Hibernate (`ddl-auto=update`).
- O script `src/main/resources/data.sql` é executado automaticamente populando o banco com dados iniciais para testes.

Para iniciar a aplicação usando o **Maven Wrapper**:

**No Windows (PowerShell / CMD):**
```powershell
.\mvnw.cmd spring-boot:run
```

**No Linux / macOS:**
```bash
./mvnw spring-boot:run
```

Ou, se preferir gerar o `.jar` e executá-lo:
```bash
./mvnw clean package -DskipTests
java -jar target/questlab-0.0.1-SNAPSHOT.jar
```

### 3. Ambiente de Produção (SQL Server)

Para executar a aplicação conectada ao **SQL Server**:
1. Certifique-se de que o banco de dados `QuestLabDB` exista na sua instância do SQL Server e ajuste as credenciais em `src/main/resources/application-producao.properties` (ou via variáveis de ambiente).
2. Execute a aplicação ativando o perfil `producao`:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=producao
```

---

### Acessos Rápidos

Com a aplicação rodando localmente na porta `8080`, o contexto base configurado é `/api`:

| Recurso | URL | Credenciais / Observações |
| :--- | :--- | :--- |
| **URL Base da API** | `http://localhost:8080/api` | Todas as rotas partem deste prefixo |
| **Swagger UI (OpenAPI)** | `http://localhost:8080/api/swagger-ui/index.html` | Documentação interativa para testar as rotas |
| **Console H2 Database** | `http://localhost:8080/api/h2` | **JDBC URL:** `jdbc:h2:mem:QuestLabDB`<br>**User Name:** `sa`<br>**Password:** *(deixar em branco)* |

---

## Rotas da API (Endpoints)

> **Nota:** Todas as rotas abaixo devem ser precedidas pelo caminho base `/api` (ex.: `http://localhost:8080/api/usuario`).

### 1. Endpoints CRUD Padrão

Todos os recursos principais do sistema possuem as 5 operações básicas padronizadas:

| Método HTTP | Caminho Relativo | Descrição | Status de Sucesso |
| :---: | :--- | :--- | :---: |
| `GET` | `/{recurso}` | Lista todos os registros cadastrados | `200 OK` |
| `GET` | `/{recurso}/{id}` | Busca um registro específico pelo ID | `200 OK` |
| `POST` | `/{recurso}` | Cadastra um novo registro (envie o JSON no Body) | `201 Created` |
| `PUT` | `/{recurso}` | Atualiza um registro existente (envie o JSON completo com `id` no Body) | `200 OK` |
| `DELETE` | `/{recurso}` | Remove um registro existente (envie o JSON com `id` no Body) | `200 OK` |

#### Recursos Disponíveis para CRUD:

| Recurso | Rota Base | Principais Campos do Payload (JSON) |
| :--- | :--- | :--- |
| **Usuários** | `/api/usuario` | `nome`, `email`, `dataNascimento`, `sexo` (`M`/`F`), `senha`, `perfil` (`ADMIN`, `PROFESSOR`, `ALUNO`), `cpf`, `celular`, `telefone`, `ativo` |
| **Instituições** | `/api/instituicao` | `razaoSocial`, `sigla`, `cnpj`, `email`, `telefone`, `ativo` |
| **Bancas** | `/api/banca` | `razaoSocial`, `sigla`, `cnpj`, `email`, `telefone`, `ativo` |
| **Concursos** | `/api/concurso` | `nome`, `ano` (`yyyy-MM-dd`), `cancelado`, `ativo`, `idBanca`, `idInstituicao` |
| **Cargos** | `/api/cargo` | `nome`, `nivelEscolaridade` |
| **Provas** | `/api/prova` | `nome`, `dataAplicacao` (`yyyy-MM-dd`), `idConcurso`, `idCargo` |
| **Disciplinas** | `/api/disciplina` | `nome` |
| **Assuntos** | `/api/assunto` | `nome`, `idDisciplina` |
| **Questões** | `/api/questao` | `enunciado`, `comentarioProfessor`, `anulada`, `idProva`, `idAssunto`, `dataAnulacao`, `dataCriacao` |
| **Alternativas** | `/api/alternativa` | `texto`, `correta`, `idQuestao` |
| **Respostas de Usuários** | `/api/usuario-resposta` | `dataResposta` (`yyyy-MM-dd`), `idUsuario`, `idQuestao`, `idAlternativaEscolhida` |

---

### 2. Endpoints de Relatórios e Indicadores

As rotas analíticas exigem a identificação do usuário solicitante via **Header HTTP** para validação de permissão por perfil (`ADMIN`, `PROFESSOR` ou `ALUNO`).

#### Relatórios de Usuários (`/api/usuario`)

| Método | Rota | Headers Obrigatórios | Query Params | Perfis Permitidos | Descrição |
| :---: | :--- | :--- | :--- | :---: | :--- |
| `GET` | `/api/usuario/ativos` | `id-usuario` | — | `ADMIN` | Lista todos os usuários ativos com nome, e-mail, perfil e data de nascimento. |
| `GET` | `/api/usuario/desempenho/{idUsuarioAlvo}` | `id-usuario-solicitante` | `dataInicial` *(opcional, yyyy-MM-dd)*<br>`dataFinal` *(opcional, yyyy-MM-dd)* | `ADMIN`, `ALUNO` *(apenas próprio ID)* | Retorna total de respostas, acertos, erros e taxa de aproveitamento (%) do usuário alvo. |
| `GET` | `/api/usuario/participacao` | `id-usuario` | `mes` *(int)*<br>`ano` *(int)* | `ADMIN` | Retorna total de usuários, total de ativos, questões respondidas no mês e percentual de crescimento em relação ao mês anterior. |
| `GET` | `/api/usuario/evolucao` | `id-usuario` | `pagina` *(default: 0)*<br>`tamanho` *(default: 10)* | `ALUNO` | Retorna página ordenada com o desempenho do aluno por disciplina e assunto (tentativas e % de acertos). |
| `GET` | `/api/usuario/indicadores` | `id-usuario` | — | `ADMIN` | Dashboard executivo com métricas globais de usuários ativos, banco de questões e desempenho geral. |

#### Relatórios de Disciplinas (`/api/disciplina`)

| Método | Rota | Headers Obrigatórios | Query Params | Perfis Permitidos | Descrição |
| :---: | :--- | :--- | :--- | :---: | :--- |
| `GET` | `/api/disciplina/desempenho` | `id-usuario` | `idDisciplina` *(obrigatório)*<br>`id-concurso` *(opcional)*<br>`data-inicial` *(obrigatório, yyyy-MM-dd)*<br>`data-final` *(obrigatório, yyyy-MM-dd)* | `ADMIN`, `PROFESSOR` | Retorna a média de acertos, total de tentativas e quantidade de questões anuladas da disciplina no período. |

#### Relatórios de Provas (`/api/prova`)

| Método | Rota | Headers Obrigatórios | Query Params | Perfis Permitidos | Descrição |
| :---: | :--- | :--- | :--- | :---: | :--- |
| `GET` | `/api/prova/provas-por-concurso` | `id-usuario` | `id-concurso` *(obrigatório)*<br>`ano` *(opcional, int)*<br>`pagina` *(default: 0)*<br>`tamanho` *(default: 10)* | `ADMIN` | Lista de forma paginada as provas vinculadas a um concurso e seus respectivos cargos e datas de aplicação. |

#### Relatórios de Questões (`/api/questao`)

| Método | Rota | Headers Obrigatórios | Query Params | Perfis Permitidos | Descrição |
| :---: | :--- | :--- | :--- | :---: | :--- |
| `GET` | `/api/questao/questoes-por-disciplina` | `id-usuario` | — | `ADMIN`, `PROFESSOR` | Retorna o quantitativo total de questões cadastradas e questões anuladas agrupadas por disciplina. |
| `GET` | `/api/questao/questoes-anuladas` | `id-usuario` | `data-inicial` *(obrigatório, yyyy-MM-dd)*<br>`data-final` *(obrigatório, yyyy-MM-dd)*<br>`pagina` *(default: 0)*<br>`tamanho` *(default: 10)* | `ADMIN`, `PROFESSOR` | Lista paginada de questões anuladas em um período, contendo resumo do enunciado, disciplina, assunto, data de anulação e comentário do professor. |

---

## Tratamento de Exceções

A API possui tratamento centralizado de erros na classe `ControllerExceptionHandler`, retornando objetos JSON padronizados:

- **`404 Not Found` (`ObjectNotFoundException`):** Quando um registro buscado por ID não existe.
- **`400 Bad Request` (`ConstraintException`, `DataIntegrityException`, `CpfCnpjException`, `MethodArgumentNotValidException`):** Violações de unicidade (ex.: CPF, CNPJ ou e-mail duplicado), erros de validação de campos ou formato de data inválido (esperado `yyyy-MM-dd`).
- **`409 Conflict` (`BusinessRuleException`):** Violação de regras de negócio ou tentativa de acesso a relatórios sem o perfil exigido.
- **`500 Internal Server Error` (`SQLException`):** Falhas de comunicação com o banco de dados.

**Exemplo de resposta de erro padrão (`StandardError`):**
```json
{
  "timestamp": 1730234400000,
  "status": 404,
  "error": "Não encontrado",
  "message": "Usuário com ID 99 não encontrado.",
  "path": "/api/usuario/99"
}
```

