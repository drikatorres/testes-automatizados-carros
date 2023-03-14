package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTest {
    //Cada teste será em um método

    @Test
    public void deveAcelerarCorretamenteUmCarroLigado() {
        //Given
        CarroServiceImpl carroService = new CarroServiceImpl();
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
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();
        carro1.setLigado(true);

        Assert.assertTrue(carro1.isLigado() == true);
    }

    @Test
    public void naoDeveUltrapassarAVelocidadeMaxima () {
        //Given
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();
        carroService1.ligar(carro1);
        carro1.setVelocidadeAtual(220);

        //When
        carroService1.acelerar(carro1, 10);

        //Then
        Assert.assertEquals(carro1.getVelocidadeMaxima(), carro1.getVelocidadeAtual());
    }

    @Test
    public void naoDeveAcelerarCarroDesligado () {
        //Given
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();

        //When
        carroService1.acelerar(carro1, 20);

        //Then
        Assert.assertFalse(carro1.getVelocidadeAtual() == 20);

    }

    @Test
    public void frearCarroParado () {
        //Given
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();
        carroService1.ligar(carro1);

        //When
        carroService1.frear(carro1, 10);

        //Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test
    public void DeveLigarCarro () {
        //Given
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();

        //When
        carroService1.ligar(carro1);

        //Then
        Assert.assertTrue(carro1.isLigado());
    }

    @Test
    public void desligarCarroLigado () {
        //Given
        CarroServiceImpl carroService1 = new CarroServiceImpl();
        Carro carro1 = new Carro();
        carroService1.ligar(carro1);

        //When
        carroService1.desligar(carro1);

        //Then
        Assert.assertFalse(carro1.isLigado());
    }
}
