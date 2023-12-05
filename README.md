# Documentação do Projeto - Controle de Gastos

## Introdução

Bem-vindo à documentação do projeto de Controle de Gastos. Este projeto foi desenvolvido utilizando Java 20, Spring Boot 3, arquitetura hexagonal, Spring WebFlux para a camada de aplicação reativa, e integração com MongoDB para persistência de dados e RabbitMQ para comunicação assíncrona.

## Visão Geral

O objetivo deste sistema é fornecer uma solução eficiente e escalável para o controle de gastos pessoais, permitindo aos usuários registrar, visualizar e analisar suas despesas de forma organizada.

## Arquitetura Hexagonal

O projeto segue o padrão de Arquitetura Hexagonal, proporcionando uma clara separação entre o domínio da aplicação e os detalhes de implementação externos. A estrutura do projeto reflete essa arquitetura, com a divisão entre domínio, adaptadores primários (entrada) e adaptadores secundários (saída).

## Tecnologias Utilizadas

1. **Java 20:**
   - Linguagem de programação principal do projeto.

2. **Spring Boot 3:**
   - Framework para simplificar o desenvolvimento de aplicativos Spring.

3. **Spring WebFlux:**
   - Suporte para programação reativa na camada de aplicação.

4. **MongoDB:**
   - Banco de dados NoSQL utilizado para armazenar as informações de gastos.

5. **RabbitMQ:**
   - Sistema de mensagens assíncrono para processamento distribuído de eventos
