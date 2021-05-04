# Api-Feira-Livre
Projeto para cadastro de feiras livres da cidade de São Paulo

![Imagem Feira](Images/feira.png)

##  Pré-requisitos para execução do projeto
- Tecnologias necessárias.

  1- Para executar os projetos é necessário ter instalado Java SE Development Kit versão 11 e o MySQL.
  
  2- Utilizar uma IDE para execução dos projetos de API desenvolvida em Java. Ex. IntelliJ ou Eclipse.
  
  3- Utilizar uma IDE para visualizar o registros criados no banco de dados. Ex. MYSQL WOrkbench
  
  ---
  
## Download do projeto

- Baixar o projeto: `$ git clone https://github.com/igor-fga/Api-Feira-Livre.git`

---

## Instalação e execução do projeto Api
Esse projeto tem como objetivo criação, edição, busca e deleção de feiras livres.

- Importar o projeto (Ex. Eclipse)

  1- No Eclipse, selecione **File > Import...**.
  
  2- Na janela de importação, expandir Maven, selecione **Existing Maven Projects**, e clicar **Next**.
  
  3- Clicar em **Browse** e entre na pasta do projeto **ApiFeiraLivre**, onde contém o **pom.xml** que você deseja importar.
  
  4- Clicar em **Finish**. O Eclipse vai importar o projeto e iniciar o download dos recursos requeridos.
  
  5- Clicar em **src/main/resources** e editar no arquivo **application.properties** o username e password para o do banco de dados instalado na sua maquina. 
  
  5- Entre no Package **br.gov.sp.prefeitura.feira** e clique na classe Java **FeiraApplication** e clique em **Run**.
  
  6- Os serviços podem ser testados utilizando o swagger no endereço *http://localhost:8080/swagger-ui/index.html*
  
  7 - O serviço também pode ser testado pela collection do postman **Api - Feira Livre.postman_collection.json** diponível na pasta raiz do projeto.
  
 ---
 
## Logs da API

- Na pasta raiz do projeto **ApiFeiraLivre** é gravado os logs no arquivo **Feira-livre-log.txt**.
