package StorePage;

import Store.GeradorEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class StorePage {
    GeradorEmail gerador = new GeradorEmail();

    public WebDriver navegador;
    public void setUp(){
        //Navegador Google
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver1.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        // Abrir pagina do site
        navegador.get("http://automationpractice.com/index.php?");
    }

    public void escolherProdutonaLoja() {
        // Clica no campo 'search'
        navegador.findElement(By.id("search_query_top")).click();
        // Limpa o campo 'search'
        navegador.findElement(By.id("search_query_top")).clear();
        // Inseri o produto desejado a procurar
        navegador.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        // Clica no botão procurar
        navegador.findElement(By.xpath("//*[contains(@class, 'btn btn-default button-search')]")).click();
        // Clica no link com o texto 'Printed Chiffon Dress'
        navegador.findElement(By.linkText("Printed Chiffon Dress")).click();
        // Escolher a cor 'green'
        navegador.findElement(By.id("color_15")).click();
        // Escolher tamanho 'M'
        navegador.findElement(By.id("group_1")).click();
        navegador.findElement(By.xpath("//*[contains(@id, 'group_1')]//*[contains(@title, 'M')] ")).click();

    }

    public void adicionarProdutonoCarrinho() {

        // Clicar para adicionar no carrinho de compras
        navegador.findElement(By.id("add_to_cart")).click();
    }

    public void prosseguirCheckout() {
        // Proceder para o checkout
        navegador.findElement(By.linkText("Proceed to checkout")).click();

    }
    public void validaProdutoEProsseguirCheckout() {
        // Validar o produto
        WebElement alt = navegador.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$18.40'])[4]/following::a[2]"));
        String textoNoElementoProduct = alt.getText();
        assertEquals("Printed Chiffon Dress", textoNoElementoProduct);
        // Prosseguir com o checkout
        navegador.findElement(By.linkText("Proceed to checkout")).click();
    }

    public void realizarCadastroCliente() {
        //inserir e-mail
        navegador.findElement(By.xpath("//*[contains(@id,'email_create')]")).click();
        navegador.findElement(By.xpath("//*[contains(@id,'email_create')]")).clear();
        navegador.findElement(By.xpath("//*[contains(@id,'email_create')]")).sendKeys(""+gerador.getNome() );
        //Após inserir o e-mail, clicar em Create an account
        navegador.findElement(By.xpath("//i[contains(@class,'icon-user left')]")).click();
        // Selecionar a opção 'Ms'
        navegador.findElement(By.id("id_gender1")).click();
        // Inserir primeiro nome
        navegador.findElement(By.id("customer_firstname")).sendKeys("Cesar");
        // Inserir Ultimo nome
        navegador.findElement(By.id("customer_lastname")).sendKeys("Batista");
        // inserir senha
        navegador.findElement(By.id("passwd")).sendKeys("Senha@00");
        // Inserir data de nascimento
        navegador.findElement(By.id("days")).sendKeys("16");
        navegador.findElement(By.id("months")).sendKeys("June");
        navegador.findElement(By.id("years")).sendKeys("1996");
        // Inserir Address
        navegador.findElement(By.id("address1")).sendKeys("Address testing");
        // Inserir city
        navegador.findElement(By.id("city")).sendKeys("miami");
        // Navegador inserir state
        navegador.findElement(By.id("id_state")).sendKeys("Florida");
        // Inserir Poste code
        navegador.findElement(By.id("postcode")).sendKeys("33101");
        // Inserir Mobile phone
        navegador.findElement(By.id("phone_mobile")).sendKeys("+17864058935");
        // Inserir 'Assign an address alias for future reference'
        navegador.findElement(By.id("alias")).click();
        navegador.findElement(By.id("alias")).clear();
        navegador.findElement(By.id("alias")).sendKeys("Address miami testing");
        // Clicar no botão 'Register'
        navegador.findElement(By.id("submitAccount")).click();
    }

    public void validarEndereco() {
        // Inserir validação do endereço
        WebElement address = navegador.findElement(By.xpath("//*[contains(@id,'address_delivery')]//li[@class='address_city address_state_name address_postcode']"));
        String addressValidar = address.getText();
        assertEquals("miami, Florida 33101", addressValidar);
        //Prosseguir clicando no botão "Procees to chekout"
        navegador.findElement(By.xpath("//*[contains(@class,'button btn btn-default button-medium')]")).click();
    }

    public void aceitarTermos() {
        // Clicar no check box para aceitar os termos
        navegador.findElement(By.id("cgv")).click();
        // Clicar no botão 'proceed to chekout
        navegador.findElement(By.xpath("//*[contains(@class,'button btn btn-default standard-checkout button-medium')]")).click();

    }

    public void validarTotalCompra() {

        // Validar o total do produto
        WebElement id = navegador.findElement(By.id("total_price"));
        String precoNoProduct = id.getText();
        assertEquals("$18.40", precoNoProduct);
    }

    public void selecionarMetodoPagamento() {
        // Selecionar ordem de pagamento
        navegador.findElement(By.xpath("//*[contains(@class,'bankwire')]")).click();
    }

    public void confirmarCompraeValidar() {
        // Clicar no botão ' I comfirm my order'
        navegador.findElement(By.xpath("//*[contains(@class,'button btn btn-default button-medium')]")).click();
        // Validar ordem de a ordem foi finalizada com sucesso
        WebElement dark = navegador.findElement(By.xpath("//p[contains(@class,'cheque-indent')]//strong[contains(@class,'dark')]"));
        String ordemValidar = dark.getText();
        assertEquals("Your order on My Store is complete.", ordemValidar);
        // fechar o navegador
        navegador.close();
    }

}
