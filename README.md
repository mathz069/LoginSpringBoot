\# Sistema de Login Seguro - Spring Boot + MongoDB Atlas



\## Descrição

Este projeto implementa um \*\*sistema de login seguro\*\* utilizando \*\*Java Spring Boot, MongoDB Atlas e Thymeleaf\*\*, permitindo:



\- Cadastro de usuários e administradores

\- Login e logout seguro

\- Controle de acesso baseado em roles (usuário e admin)

\- Senhas criptografadas com BCrypt

\- Front-end desacoplado, pronto para customização de temas



O sistema foi desenvolvido de forma modular e genérica, facilitando futuras adaptações.



---



\## Estrutura do Projeto



src/

├─ main/

│ ├─ java/com/example/AtividadeLogin/

│ │ ├─ config/ -> Configurações do Spring Security

│ │ ├─ controller/ -> Controladores de rotas (login, registro, dashboards)

│ │ ├─ model/ -> Modelos de dados (User)

│ │ ├─ repository/ -> Repositório único AuthRepository (MongoDB)

│ │ ├─ service/ -> Lógica de negócio (AuthService)

│ │ └─ AtividadeLoginApplication.java -> Classe principal do Spring Boot

│ └─ resources/

│ ├─ templates/ -> Páginas Thymeleaf (login.html, register.html, home.html)

│ ├─ static/ -> CSS e JS

│ └─ application.properties -> Configuração de banco, porta, etc.





Decisões de Design



Autenticação e Autorização



Spring Security controla autenticação por email e senha



Roles (ROLE\_USER / ROLE\_ADMIN) definem acesso às páginas



Segurança de Senha



Senhas armazenadas com BCrypt



Nunca armazenar senha em texto puro



Modularidade



AuthService centraliza lógica de cadastro e busca de usuários



AuthRepository único facilita manutenção



Front-end desacoplado



Templates Thymeleaf separados da lógica Java



Permite fácil customização de temas visuais



Admin Inicial



Criado automaticamente via CommandLineRunner se não existir



Facilita testes e administração inicial







Requisitos



Java 17+ (recomendado JDK 21)



Maven



Conta no MongoDB Atlas





Acesse no navegador:



Registro: http://localhost:8080/register



Login: http://localhost:8080/login



Home (após login): http://localhost:8080/home



Usuário Admin Inicial



Email: admin@dominio.com



Senha: admin123



Role: ROLE\_ADMIN



Ele será criado automaticamente na primeira execução se não existir.

