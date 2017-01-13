# ReaderCSV Involves

Pré-requisito
-------------

-  O arquivo **.csv** e **config.properties** devem estar presente na raiz do projeto

Como usar
---------

- Na IDE Eclipse: A classe de execução é Main, com o botão direito do mouse clique em Run As -> Java Application
- Caso a criação da .jar for requisitada as instruções são:

1.	Botão direito na pasta do projeto
2.	Clique em export
3.	Em _type field text_ escreva jar e selecione Runnable JAR file
4.	Selecione a classe Main do projeto
5.	Escolha o nome de preferência e pressione finish

- Para executar o .jar
1. Na pasta onde se encotra o .jar certifique do **pré-requisito**
2. Execute no Prompt de comando a linha   
`$ java -jar involves.jar`

Comandos disponíveis
--------------------
- **count** * - escreve no console a contagem total de registros importados (nao deve considerar a linha de cabeçalho)
- **count distinct [propriedade]** - escreve no console o total de valores distintos da propriedade (coluna) enviada 
- **filter [propriedade] [valor]** - escreve no console a linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor enviado 
- **quit** finaliza a execução



