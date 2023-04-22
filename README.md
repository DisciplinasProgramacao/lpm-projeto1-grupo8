[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10123420)
# Mercearia do Jhon Jhon

O mercado varejista está em constante evolução, e acompanhar as mudanças é essencial para manter um negócio próspero. Com isso, o varejista Jhon Jhon decidiu investir em um sistema para sua mercearia que o ajude a gerenciar suas vendas.

O objetivo deste projeto é criar um sistema completo para a mercearia, permitindo que o proprietário administre o estoque e as finanças (compra e vendas dos produtos) do estabelecimento de maneira mais eficiente.

--

## Nota base do grupo: 11,4

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários
- sem tirar pontos (por enquanto)
    - não adianta lançar uma exceção e não tratar no main. Mata o sistema do mesmo jeito.
    - construtor deve ter documentação dos parâmetros
    
### Diagrama + aderência das classes ao diagrama: 0/2 pontos 
	- não encontrei diagrama
### Requisitos corretamente implementados: 5/6 pontos 
	- produto (preço, estoque)
	- estoque (valor, abaixo do estoque)
        - um estoque CONTÉM uma lista. os métodos de estoque ficam no estoque, não na lista (que apenas guarda os dados)
	- sistema (vender, comprar, consultas)
        - compra está pulando nome do produto e dá erro.

### Documentação de código: 2,4/3 pontos 
- documentação deve ser completa. Por ex: para que serve o logger em efetuar venda? O que significa um retorno 0 no método? Quando/por que é gerada uma exceção?	
	
### Testes (quantidade e qualidade): 4/4 pontos 
    - produto: /2 pontos
	- estoque: /2 pontos
	
--

## Alunos integrantes da equipe

* Arthur Jansen Oliveira
* Bárbara Mattioly Andrade 
* Gabriel Pimentel Tabatinga
* Henrique Grissi C Soeiro de Carvalho
* Laura Enísia Rodrigues Melo

## Professores responsáveis

* João Caram Santos de Oliveira

## Link UML
https://app.diagrams.net/#G1QZmhGfsUB86qOo25eu-PLi-GJ5yVat4v

![TP1-Diagrama de Classes drawio](https://user-images.githubusercontent.com/89463780/225186211-dfe33dcc-7fb5-41b6-a73c-5e3c136fe28a.png)

