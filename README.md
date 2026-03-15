# MoradaApp - Sistema de Gerenciamento de Condomínios

## 📋 Descrição

MoradaApp é uma aplicação robusta e escalável para gerenciamento completo de condomínios. Desenvolvida inicialmente como projeto de estudo, visa oferecer uma solução profissional para administradores de condomínios, facilitando o controle de unidades, moradores, funcionários e encomendas. Com uma arquitetura moderna e APIs RESTful, o sistema garante eficiência, segurança e facilidade de uso.

## 🚀 Funcionalidades

- **Cadastro de Condomínios**: Registre condomínios com informações completas, incluindo estrutura (blocos, andares, apartamentos, gardens e coberturas).
- **Gerenciamento de Apartamentos**: Geração automática de apartamentos baseada na estrutura do condomínio, com suporte a tipos especiais (gardens e coberturas).
- **Controle de Encomendas**: Cadastro e rastreamento de encomendas recebidas, com status de entrega.
- **Cadastro de Funcionários**: Gerencie funcionários do condomínio, com roles e permissões.
- **APIs RESTful**: Endpoints bem documentados para integração com frontends e outros sistemas.

## 🛠️ Tecnologias Utilizadas

- **Backend**: Java 17, Spring Boot 3.x
- **Banco de Dados**: PostgreSQL (ou H2 para desenvolvimento)
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Documentação de API**: Swagger/OpenAPI
- **Testes**: JUnit, Mockito
- **Outros**: Lombok, Jackson (para JSON), Spring Security (futuro)

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- PostgreSQL (para produção) ou H2 (para desenvolvimento)

## 🔧 Instalação e Configuração

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/moradaapp.git
   cd moradaapp
   ```

2. **Configure o banco de dados**:
   - Para desenvolvimento (H2): Nenhuma configuração adicional necessária.
   - Para produção (PostgreSQL): Atualize `application.yaml` com suas credenciais.

3. **Compile e execute**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Acesse a aplicação**:
   - API: `http://localhost:8080`
   - Documentação Swagger: `http://localhost:8080/swagger-ui.html`

## 📖 Uso

### Cadastro de Condomínio
Envie uma requisição POST para `/condominios` com o payload JSON contendo nome, CNPJ, endereço e estrutura.

Exemplo de payload:
```json
{
  "nome": "Residencial Morada Verde",
  "cnpj": "12345678000100",
  "endereco": {
    "logradouro": "Rua das Palmeiras",
    "numero": "1200",
    "bairro": "Centro",
    "cidade": "Campinas",
    "estado": "SP",
    "cep": "13000000"
  },
  "estrutura": {
    "blocos": 2,
    "andares": 5,
    "apartamentosPorAndar": 4,
    "temGarden": true,
    "gardensPorBloco": 2,
    "temCobertura": true,
    "coberturasPorBloco": 2
  }
}
```

### Outros Endpoints
- **Apartamentos**: GET `/apartamentos` (listar), POST `/apartamentos` (cadastrar)
- **Encomendas**: GET `/encomendas`, POST `/encomendas`
- **Funcionários**: GET `/funcionarios`, POST `/funcionarios`

Consulte a documentação Swagger para detalhes completos.

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

## 🤝 Contribuição

Contribuições são bem-vindas! Siga estes passos:

1. Fork o projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova funcionalidade'`).
4. Push para a branch (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request.

## 📄 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 📞 Contato

- **Desenvolvedor**: Camila Maria Moreira Ferreira
- **Email**: camilla.ferrera@gmail.com
- **LinkedIn**: (https://linkedin.com/in/camila-moreira-49a206117/)

---

*MoradaApp - Simplificando a gestão de condomínios.*</content>
<parameter name="filePath">C:\Projetos\moradaapp\moradaapp-backend\morada-app\README.md
