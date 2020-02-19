# language:pt

Funcionalidade: Realizar compra


#Dado, Quando, Entao, E


Cenario: Realizar uma compra com sucesso!

  Dado Que acesso o site
  E Escolha um produto qualquer da loja
  Quando Adicione o produto escolhido ao carrinho
  E prossiga para o checkout
  Quando Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo
  Dado Realize o cadastro do cliente preenchendo todos os campos obrigatorios dos formularios
  E valide se o endereco esta correto e prossiga
  E aceite os termos de servicos e prossiga
  E valide o valor total da compra
  E selecione um metodo de pagamento e prossiga
  Entao confirme a compra e valide se foi finalizada com sucesso
