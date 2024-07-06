
# Spring Application README

## Participantes
- Brendon de Lima
- Milene Aparecida
- Thomas Maffezzolli

## Descrição
Este projeto é uma aplicação Spring que permite o cadastro de usuários através de uma API REST. Abaixo estão as instruções para iniciar a aplicação e realizar o cadastro de um usuário.

## Requisitos
- JDK 11 ou superior
- Maven

## Passos para Iniciar a Aplicação

2. **Compile o projeto:**
   ```sh
   mvn clean install
   ```

3. **Execute a aplicação:**
   ```sh
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Cadastro de Usuário

Para cadastrar um usuário na aplicação, utilize o endpoint `@PostMapping("/register")`. O endpoint aceita uma requisição POST com o corpo no formato JSON contendo os seguintes campos:

- `username` (String): Nome de usuário.
- `password` (String): Senha do usuário.
- `role` (UserRole): Função do usuário. Utilize o valor `USER`.

### Exemplo de Requisição

Endpoint: `http://localhost:8080/register`

Método: `POST`

Cabeçalho: `Content-Type: application/json`

Corpo da Requisição:
```json
{
  "username": "novoUsuario",
  "password": "senhaSegura",
  "role": "USER"
}
```


