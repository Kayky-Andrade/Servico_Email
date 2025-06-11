# Email Service - Spring Boot + AWS SES

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)](https://spring.io/projects/spring-boot)
[![AWS SES](https://img.shields.io/badge/AWS--SES-Email%20Service-orange)](https://aws.amazon.com/ses/)
[![License](https://img.shields.io/badge/license-MIT-lightgrey.svg)](LICENSE)

> Projeto desenvolvido por **Kayky Andrade** como parte de uma aplicação de serviço de e-mail usando AWS SES com Spring Boot.

## 🚀 Visão Geral

Este projeto é um microserviço responsável pelo envio de e-mails utilizando o Amazon SES (Simple Email Service). Ele é construído com Spring Boot e segue boas práticas REST.
O projeto é local, feito somente para estudo de interpletação de microserviços

## 🏗️ Tecnologias Utilizadas

* **Java JDK 24**
* **Spring Boot 3.5.0**
* **Spring Web**
* **AWS SDK SES (v2)**
* **Lombok**
* **DevTools**
* **Maven**
* **Amazon SES**

## 🚧 Configuração e Execução

### 1. Configurar credenciais AWS

* Crie um usuário IAM com permissão para o Amazon SES.
* Adicione suas credenciais em `application.properties`:

```properties
aws.accessKeyId=SEU_ACCESS_KEY
aws.secretAccessKey=SEU_SECRET_KEY
aws.region=us-east-1
spring.mail.from=email_verificado@seudominio.com
```

> **Atenção:** O email do remetente (`spring.mail.from`) precisa estar verificado no console do Amazon SES.

### 2. Verificação do Domínio ou Email

* No Amazon SES, verifique o email ou domínio que deseja utilizar como remetente.
* Envie um e-mail de teste pelo painel da AWS para garantir que o email esteja saindo corretamente (confira na caixa de SPAM também).

### 3. Executar o Projeto

```bash
./mvnw spring-boot:run
```

O servidor iniciará na porta `8080`.

## 📉 Endpoints Disponíveis

### POST `/email`

Envia um e-mail para o destinatário informado.

#### Requisição:

Usando o Insomnia para testar 

```json
{
  "to": "destinatario@exemplo.com",
  "subject": "Assunto do Email",
  "body": "Conteúdo do email em texto simples"
}
```

#### Respostas:

* `200 OK` - Email enviado com sucesso.
* `400 Bad Request` - Erro de validação.
* `500 Internal Server Error` - Problemas no envio do email.

## 🌐 Testando com Insomnia/Postman

* Método: `POST`
* URL: `http://localhost:8080/email`
* Body: JSON (como o exemplo acima)

## 🚫 Evitar SPAM

Muito provavelmente vai cair o email na caixa de spancxxx

* Utilize domínios com DKIM configurado.
* Adicione SPF e DKIM no DNS.
* Verifique o domínio no Amazon SES para autorizar envio.
* Evite palavras de SPAM no corpo do email.

## 📖 Estrutura do Projeto

```
email-service/
├── src/main/java/com/kayky/email_service
│   ├── controller/EmailController.java
│   ├── service/EmailService.java
│   ├── model/EmailRequest.java
│   └── EmailServiceApplication.java
├── resources/
│   └── application.properties
└── pom.xml
```

## 🌟 Melhorias Futuras

* Envio de e-mails HTML
* Integração com filas (ex: SQS ou Kafka)
* Agendamento de e-mails (Quartz)
* Monitoramento via Spring Actuator

## 💼 Autor

Desenvolvido por [Kayky Andrade](https://github.com/KaykyAndrade)

## ✅ Licença

Este projeto está licenciado sob a licença MIT.
