# pokedex-egsys
Projeto pokédex - Android

Este projeto trata-se do desafio de codificação Pokédex.

A organização dos diretórios estão de acordo com o o padrão de arquitetura baseado em Model, View e Viewl-Model (MVVM), sendo:
1) data/models: representa os "data class" para suportar as informaçoes da API e serem consumidos para a exibição nas views;
2) data/remote/responses e ServiceAPI.kt: realizam as solicitações HTTP, via Retrofit2, para a API (endpoints) visando obter os dados dos Pokémons. Além de uma relação de detalhes de pokemons, em que somente uma parte é utilizada;
3) di: responsável pela conexão e conversão do consumo do serviço online e instâcia do retrofit, com a implementação da interface que contém o endpoint da api pokedex;
4) repository: gerenciará as consultas e as atualizações de dados do webservice. Sendo vinculado a partir das ViewsModels;
5) viewModels: da tela principal e secundário (detalhes dos pokemons);
6) ui/componentes: arquivos de interface Composables para a tela principal e secundário. Ambas comunicam-se com os respectivos viewModels;
7) ui/theme: relação dos tipos de pokemons e as cores que seriam associados, contudo não foi devidamente utilizado; 
8) util: constantes, como URL e paginação. Além de cores que são relacionadas com os tipos de pokemons. E status da aplicação;
9) res: imagens, strings e demais informações relacionadas.
