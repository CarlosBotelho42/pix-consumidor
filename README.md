## Sobre o projeto

pix-consumidor é um projeto para fins de aprendizado relacionado ao apache kafka.

---

## Funcionalidades

- [x] Envio de solitação de um pix para o broker;
- [x] Validar Pix;
- [x] Cadastrar chaves Pix;
- [x] Validar chaves Pix;


---

## Layout

O projeto desse repositório é apenas a API Backend.

---

## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Kafka 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**



## Alterações

- [x] Integrar o Spring com o Kafka, utilizando bibliotecas específicas que facilitam a integração do Kafka com uma aplicação Spring, de acordo com seus padrões de inversão de controle e injeção de dependência.;
- [x] Implementar um produtor do Kafka com o Spring, que vai enviar as mensagens com informações do PIX, usando a biblioteca spring-kafka. Para a implementação do produtor usamos a classe KafkaTemplate, onde temos o método send, no qual podemos definir um tópico para enviar uma mensagem. Ainda neste método, enviamos um objeto como parâmetro que será serializado como um JSON para ser armazenado no Kafka.;
- [x] Implementar um consumidor do Kafka com o Spring, que vai processar as mensagens com informações dos pagamentos que foram enviadas para o Kafka. Para a implementação do consumidor usamos a anotação @KafkaListener, que define um método que será executado sempre que uma mensagem for recebida em um tópico.;
- [x] 
