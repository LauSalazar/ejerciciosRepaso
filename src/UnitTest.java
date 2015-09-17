



import org.junit.Assert;
import org.junit.Test;

public class UnitTest {



    @Test //Así se le dice que este método es un unit test
    //De click derecho -> Run as -> JUnit test 
    public void SumaDiagonalesTest(){
     
        int [][] matrix = {{1,0,0},{0,1,0},{0,0,1}}; //la matriz de identidad
        
        //vamos a probar si su método  de su de diagonales suma bien
        
        int resultado = Funciones.sumaDiagonales(matrix,3);
        //Assert => afirmar, asegurar
        Assert.assertEquals(3, resultado); //Estoy diciendo que la función sumaDiagonales con esa matrix debería dar 3 , pero da 4. 
                                            //Osea o que su método está malo o yo no entendí el ejercicio
        
       int [][] matrix2 = {{1,0,1},{0,1,0},{1,0,1}};
       
       resultado = Funciones.sumaDiagonales(matrix2,3);
       
       Assert.assertEquals(6, resultado); //Con esta debería dar 6
    }
    
    //Haga otro método para probar la función de los pascales
    
    
    
     @Test
     public void repetidoListaLigadaTest(){
         Nodo cabeza1 = new Nodo(1);
         cabeza1.setSiguiente(new Nodo(1));
         Nodo cabeza2  = new Nodo(1);
         cabeza2.setSiguiente(new Nodo(1));
         
         Nodo cabezaRes = Funciones.repetidos2(cabeza1, cabeza2);
         //cabezaRes debería ser distinto de nulo, el dato igual a 1 =>
         Assert.assertNotNull(cabezaRes);
         Assert.assertNotNull(cabezaRes.getSiguiente());
         
         Assert.assertEquals(1, (int)(cabezaRes.getSiguiente().getDato())); //Tiene un ciclo infinito si está probando lo que códifica?
         
         Assert.assertNull(cabezaRes.getSiguiente().getSiguiente()); //y solo debería tener un elemento
     }
}
