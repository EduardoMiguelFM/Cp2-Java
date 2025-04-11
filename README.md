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

__________________________________________________________

http://localhost:8080/swagger-ui/index.html
__________________________________________________________

POST:
{
  "nome": "João Silva",
  "cpf": "12345678901",
  "telefone": "(11) 91234-5678",
  "cnh": "12345678900",
  "status": "ATIVO",
  "dataCadastro": "2024-04-10"
}

{
  "modelo": "Honda CG 160",
  "placa": "ABC1D23",
  "status": "DISPONIVEL",
  "dataAluguel": "2024-04-10",
  "quilometragem": 1000.5,
  "entregadorId": 1
}
