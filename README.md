## ibov-struct-tools

Este projeto realiza transformações e análises em um arquivo de transações da B3 (Bolsa de Valores Brasileira) utilizando Java e manipulação de arquivos CSV. Inclui tratamento de datas, filtragens condicionais e ordenações com múltiplos algoritmos de ordenação aplicados em diferentes cenários.

##  Começando

Essas instruções te ajudarão a rodar o projeto localmente usando Maven.

###  Pré-requisitos

- Java JDK 17+
- Apache Maven 3.8+
- Git
- Um editor como IntelliJ IDEA, Eclipse ou VS Code

---

## 📁 Arquivo de Dados (CSV)

⚠️ **Importante:** O arquivo `b3_stocks_1994_2020.csv` **não está incluso no repositório**, pois está listado no `.gitignore`. Você precisa adicioná-lo manualmente.

O arquivo pode ser baixado no site `https://www.kaggle.com/datasets/felsal/ibovespa-stocks/data`.

### ➕ Como adicionar o arquivo CSV:

1. Crie o diretório `src/main/resources` se ele ainda não existir:

```bash
mkdir -p src/main/resources
```
2. Copie o seu arquivo CSV original e coloque na pasta `resources`:

```bash
src/main/resources/b3_stocks_1994_2020.csv
```

 Instalação e Execução

Compile o projeto:

```bash
mvn clean compile
```

Execute a aplicação:

```bash
mvn exec:java -Dexec.mainClass="org.example.b3stocks.Main"
```

Substitua `org.example.b3stocks.Main` pelo nome completo do seu pacote e classe principal.


 Transformações

 T1 — Conversão de Data

- Converte datas de YYYY-MM-DD para DD/MM/AAAA.

- 📁 Gera: b3stocks_T1.csv

 F1 — Maior Volume por Dia

- A partir de b3stocks_T1.csv, mantém apenas um registro por dia com o maior volume negociado.

- 📁 Gera: b3stocks_F1.csv

 F2 — Volume Acima da Média

- Filtra registros de b3stocks_T1.csv que possuem volume negociado acima da média diária.

- 📁 Gera: sobreescreve o arquivo b3stocks_T1.csv

