# ReaderCSV Involves

Pr�-requisito
-------------

-  O arquivo **.csv** e **config.properties** devem estar presente na raiz do projeto

Como usar
---------

- Na IDE Eclipse: A classe de execu��o � Main, com o bot�o direito do mouse clique em Run As -> Java Application
- Caso a cria��o da .jar for requisitada as instru��es s�o:

1.	Bot�o direito na pasta do projeto
2.	Clique em export
3.	Em _type field text_ escreva jar e selecione Runnable JAR file
4.	Selecione a classe Main do projeto
5.	Escolha o nome de prefer�ncia e pressione finish

- Para executar o .jar
1. Na pasta onde se encotra o .jar certifique do **pr�-requisito**
2. Execute no Prompt de comando a linha   
`$ java -jar involves.jar`

Comandos dispon�veis
--------------------
- **count** * - escreve no console a contagem total de registros importados (nao deve considerar a linha de cabe�alho)
- **count distinct [propriedade]** - escreve no console o total de valores distintos da propriedade (coluna) enviada 
- **filter [propriedade] [valor]** - escreve no console a linha de cabe�alho e todas as linhas em que a propriedade enviada possua o valor enviado 
- **quit** finaliza a execu��o



