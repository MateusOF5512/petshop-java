# Projeto POO Petshop
CRUD simples em Java para um petshop para um projeto de faculdade (Programação Orientada à Objetos)

# Explicação dos Packages

### Model
> **Camada que define as entidades** (`Pet`, `Cliente`, `Funcionario` e outras)
com seus atributos, construtores e getters/setters.

### Repository
> **Camada que simula o banco de dados**. Mantém as listas de dados e expõe
métodos básicos de acesso *(adicionar, buscar, remover)* consumidos pela camada Service.

### Service
> **Camada que consome o Repository e expõe as operações
do CRUD** *(criar, buscar, atualizar, remover)* com suas validações.

### Ui
> **Camada de interação com o usuário**. Exibe os menus e captura os inputs,
consumindo os métodos da camada Service para executar as operações.

### Util
> **Camada que define ferramentas** que podem ser utilizadas em quaisquer outras camadas.

# Ordem Lógica dos Packages
> " → " = consome de / pode consumir de
```
UI → Service → Repository → Model
Qualquer camada → Util

```

# Documentação de métodos
> Os métodos estão documentados nas classes Clientes (`Cliente`, `ClienteRepository`, `ClienteServices`, etc). Como a lógica se repete para as demais classes (`Funcionario`, `Pet`, etc), a explicação serve como referência geral para todas elas.