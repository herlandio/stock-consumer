# Stock Consumer

## Descrição

O **Stock Consumer** é um serviço dedicado ao consumo de mensagens no [sistema de gerenciamento de estoque](https://github.com/herlandio/stock-clean-arch). Ele consome notificações de diferentes níveis de criticidade, processando mensagens de acordo com ações específicas para cada nível. Este serviço é parte integrante do ecossistema, garantindo eficiência e resiliência no tratamento de alertas relacionados ao gerenciamento de estoque.

## Funcionalidades

**1. Consumo de Mensagens Kafka**
- Escuta tópicos configurados para diferentes níveis de criticidade:
    - **critical-stock-notifications**
    - **moderate-stock-notifications**
    - **low-stock-notifications**
- Processamento específico baseado no nível de criticidade da mensagem.

**2. Tratamento por Nível de Criticidade**

**Crítico:**

- Notificação via e-mail para administradores.
- Tratamento imediato de situações urgentes.

**Moderado:**

- Criação de tickets para acompanhamento.
- Ações escalonáveis para problemas moderados.

**Baixo:**
- Registro em sistemas de monitoramento.
- Logging para análise futura.

**3. Resiliência**

 - Configuração de Retry com até 3 tentativas e intervalo fixo de 1 segundo.
 - Integração com Dead Letter Queue para mensagens que falham.
 - Logs detalhados para rastreamento de erros e monitoramento contínuo.

## Tecnologias Utilizadas

- Spring Boot: Framework principal para construção do serviço.
- Spring Kafka: Biblioteca para integração com Kafka.

## Configuração e Execução
### Pré-requisitos
- Kafka rodando localmente ou em um servidor configurado.
- Java 17 ou superior instalado.

### Passos para Execução
Clone o repositório:
```
git clone https://github.com/herlandio/stock-consumer
```

Compile e execute o projeto:

```./mvnw spring-boot:run```

### Próximos Passos

1. Implementar lógica de envio de e-mails no CriticalMessageHandler.
2. Criar integração com sistemas de monitoramento no LowMessageHandler.
3. Automatizar criação de tickets no ModerateMessageHandler.