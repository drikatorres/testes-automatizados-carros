package service;

import model.Carro;
import org.junit.*;

public class CarroServiceTest {
    //Cada teste será em um método

    CarroServiceImpl carroService;
    @BeforeClass
    public static void beforeClass () {
        System.out.println("Before class");
    }
    //metodo executa antes de cada teste
    @Before
    public void before () {
        carroService = new CarroServiceImpl();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
        //fechar
    }

    //método executa depois de cada tesste
    @After
    public void after () {
        System.out.println("Fim do teste");
    }

    @Test
    public void deveAcelerarCorretamenteUmCarroLigado() {
        //Given
        Carro carro = new Carro();
        carroService.ligar(carro);

        //When
        carroService.acelerar(carro, 10);

        //Sempre que um método de teste NÃO possuir um assert ele vai passar
        //Then - Asserts
        //Assert.assertTrue(carro.getVelocidadeAtual() == 10);

        //O que espera vs o que é
        Assert.assertEquals(10, carro.getVelocidadeAtual());


    }

    @Test
    public void deveLigarCorretamente () {
        Carro carro1 = new Carro();
        carro1.setLigado(true);

        Assert.assertTrue(carro1.isLigado() == true);
    }

    @Test
    public void naoDeveUltrapassarAVelocidadeMaxima () {
        //Given
        Carro carro1 = new Carro();
        carroService.ligar(carro1);
        carro1.setVelocidadeAtual(220);

        //When
        carroService.acelerar(carro1, 10);

        //Then
        Assert.assertEquals(carro1.getVelocidadeMaxima(), carro1.getVelocidadeAtual());
    }

    @Test
    public void naoDeveAcelerarCarroDesligado () {
        //Given
        Carro carro1 = new Carro();

        //When
        carroService.acelerar(carro1, 20);

        //Then
        Assert.assertFalse(carro1.getVelocidadeAtual() == 20);

    }

    @Test
    public void frearCarroParado () {
        //Given
        Carro carro1 = new Carro();
        carroService.ligar(carro1);

        //When
        carroService.frear(carro1, 10);

        //Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test
    public void DeveLigarCarro () {
        //Given
        Carro carro1 = new Carro();

        //When
        carroService.ligar(carro1);

        //Then
        Assert.assertTrue(carro1.isLigado());
    }

    @Test
    public void desligarCarroLigado () {
        //Given
        Carro carro1 = new Carro();
        carroService.ligar(carro1);

        //When
        carroService.desligar(carro1);

        //Then
        Assert.assertFalse(carro1.isLigado());
    }
}
