# 📈 ibov-struct-tools

Este projeto realiza **transformações** e **análises** sobre um grande arquivo CSV de transações da B3 (Bolsa de Valores Brasileira), utilizando Java. O projeto inclui tratamento de datas, filtragens condicionais e diversas ordenações com múltiplos algoritmos, aplicadas em diferentes cenários (melhor, médio e pior caso).

---

## 🚀 Começando

Essas instruções te ajudarão a rodar o projeto localmente usando Maven.

### 🔧 Pré-requisitos

- Java JDK 23+
- Apache Maven 3.8+
- Git
- Editor de código (IntelliJ IDEA, Eclipse ou VS Code)

---

## 🌿 Branches do Projeto

Este repositório está organizado em duas branches principais:

- 🔁 **Transformações**: `versao-transformacao`
- 📊 **Ordenações**: `versao-ordenacao`

---

## 📁 Arquivo de Dados (CSV)

⚠️ **Importante:** o arquivo `b3_stocks_1994_2020.csv` **não está incluso** no repositório (está listado no `.gitignore`). Você deve adicioná-lo manualmente.

📥 Baixe o arquivo original do Kaggle:  
https://www.kaggle.com/datasets/felsal/ibovespa-stocks/data

### ➕ Como adicionar:

```bash
mkdir -p src/main/resources
cp <seu_arquivo_baixado.csv> src/main/resources/b3_stocks_1994_2020.csv
```

---

## ⚙️ Instalação e Execução

Para compilar:

```bash
mvn clean compile
```

Para executar:

```bash
mvn exec:java -Dexec.mainClass="org.example.b3stocks.Main"
```

> Substitua `"org.example.b3stocks.Main"` pelo caminho da sua classe principal.

---

## 🔄 Transformações

### T1 — Conversão de Data

- Converte datas de `YYYY-MM-DD` para `DD/MM/AAAA`.
- 📁 Gera: `b3stocks_T1.csv`

### F1 — Maior Volume por Dia

- Mantém apenas o registro com o maior volume de cada dia.
- 📁 Gera: `b3stocks_F1.csv`

### F2 — Volume Acima da Média

- Filtra registros com volume acima da média diária.
- 📁 Sobrescreve: `b3stocks_T1.csv`

---

## 🔢 Ordenações

Todas as ordenações utilizam como entrada o arquivo `b3stocks_T1.csv` gerado pela transformação de data (T1).

Para cada ordenação, são aplicados **todos os algoritmos** listados abaixo, considerando **3 cenários**:
- Melhor Caso
- Caso Médio
- Pior Caso

### Algoritmos Utilizados:

- Selection Sort  
- Insertion Sort  
- Merge Sort  
- Quick Sort  
- Counting Sort  
- Heap Sort  
- Quick Sort com Mediana de 3  

---

### 1️⃣ Ordenação por Ticker (ordem alfabética)

- Campo: `ticker` (nome dos papéis negociados)
- 🔽 Ordem: Alfabética (A-Z)
- ⚠️ Alguns algoritmos podem não se aplicar diretamente (ex: Counting Sort)
- 📁 Exemplo de arquivos gerados:
  - `b3stocks_ticker_insertionSort_medioCaso.csv`
  - `b3stocks_ticker_mergeSort_piorCaso.csv`

---

### 2️⃣ Ordenação por Volume (do menor para o maior)

- Campo: `volume`
- 🔽 Ordem: Crescente
- 📁 Exemplo de arquivos gerados:
  - `b3stocks_volume_quickSort_melhorCaso.csv`
  - `b3stocks_volume_heapSort_piorCaso.csv`

---

### 3️⃣ Ordenação por Flutuação Diária (High - Low)

- Campo: `high - low` (maior variação intradiária)
- 🔽 Ordem: Decrescente
- 📁 Exemplo de arquivos gerados:
  - `b3stocks_fluctuations_mergeSort_medioCaso.csv`
  - `b3stocks_fluctuations_quickSortMediana_piorCaso.csv`

---

## 📂 Estrutura de Pastas

```
src/
 └── main/
     └── java/
         └── org/
             └── example/
                 └── b3stocks/
                     ├── Main.java
                     ├── ...
     └── resources/
         └── b3_stocks_1994_2020.csv (adicionado manualmente)
```

---
