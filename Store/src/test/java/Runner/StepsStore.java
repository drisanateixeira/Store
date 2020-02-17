package Runner;

import StorePage.StorePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepsStore {
    public static StorePage storePage = new StorePage();
    @Dado("^Que acesso o site$")
    public static void acessarSite() {
        storePage.setUp();

    }

    @E("^Escolha um produto qualquer da loja$")
    public static void escolherProduto() {
        storePage.escolherProdutonaLoja();
    }

    @Quando("^Adicione o produto escolhido ao carrinho$")
    public static void adicionarProdutoCarrinho() {
        storePage.adicionarProdutonoCarrinho();
    }

    @E("^prossiga para o checkout$")
    public static void prosseguirCheckout() {
        storePage.prosseguirCheckout();
    }
    @Entao("^Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo$")
    public static void validarProdutoCarrinhoEProsseguir() {
        storePage.validaProdutoEProsseguirCheckout();
    }
    @Dado("^Realize o cadastro do cliente preenchendo todos os campos obrigatorios dos formularios$")
    public static void realizarCadastro() {
        storePage.realizarCadastroCliente();
    }
    @E("^valide se o endereco esta correto e prossiga$")
    public static void validaEndereco() {
        storePage.validarEndereco();
    }
    @E("^aceite os termos de servicos e prossiga$")
    public static void aceitaTermos() {
        storePage.aceitarTermos();
    }
    @E("^valide o valor total da compra$")
    public static void validaTotal() {
        storePage.validarTotalCompra();
    }

    @E("^selecione um metodo de pagamento e prossiga$")
    public static void selecionaPagamento() {
        storePage.selecionarMetodoPagamento();
    }
    @Entao("^confirme a compra e valide se foi finalizada com sucesso$")
    public static void confirmaCompraValida() {
        storePage.confirmarCompraeValidar();
    }
}
