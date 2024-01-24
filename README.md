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
- [x] Configurar os grupos de usuários, criando duas instâncias diferentes na nossa aplicação. Essa configuração pode ser feita diretamente na anotação @KafkaListener, no atributo groupId. Com isso, se os consumidores estiverem no mesmo grupo, o Kafka fará um balanceamento de carga entre os diferentes consumidores. Já se os consumidores estiverem em grupos diferentes, eles receberão as mesmas mensagens que podem ser processadas para objetivos diferentes.
- [x] Fazer configurações avançadas no consumidor para otimizar a conexão com o Kafka. Podemos fazer essas configurações em uma classe especial do Spring, que possui a anotação @Configuration. Nessa classe, podemos inserir diversas configurações como a MAX_POLL_RECORDS_CONFIG, que indica a quantidade de registros que um consumidor irá receber do Kafka, e a ALLOW_AUTO_CREATE_TOPICS_CONFIG, que permite que um tópico seja criado na primeira vez que ele for utilizado na aplicação.
- [x] Configurar e utilizar retentativas no consumidor, pois quando há uma exceção, por padrão, a mensagem não é consumida, e há casos em que é interessante que seja processada. No Kafka, é possível configurar para que as retentativas sejam automáticas. Essa configuração é feita com a anotação @RetryableTopic, e ela possui diversas configurações possíveis, como o número de retentativas que serão feitas e quais as exceções que devem ser consideradas para as retentativas.