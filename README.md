-ESTRUTURAS-
Spring Boot 3.4 (API RESTful)
Java 17 + Gradle
H2 Database para testes
Swagger (documentação)
Spring HATEOAS (links navegáveis)
Bean Validation (validações automáticas)

-ENTIDADES-
Entregador: nome, CPF, telefone, CNH, status, data de cadastro.
MotoAlugada: modelo, placa, status, quilometragem, data e entregador vinculado.
Operações implementadas: CRUD completo, com validação, atualização e exclusão.
Relacionamento: Moto pertence a um Entregador.

-CAMADAS-
model: entidades do sistema
dto: transferência de dados (input/output)
mapper: conversão entre entidades e DTOs
repository: acesso ao banco de dados
service: regras de negócio
controller: endpoints da API
exception: tratamento global de erros

-CONCLUSÃO-
Como estruturar uma API moderna e escalável
Como validar dados e documentar a API
Importância da organização por camadas
Como funciona a lógica por trás de um serviço como o da Mottu
Nos sentimos mais preparados para o Challenge
