/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa_17130854_proyecto_01;

/**
 *
 * @author josea
 */
public class PA_17130854_Proyecto_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayCuerpo cuerpos = new ArrayCuerpo(2);
        cuerpos.addCuerpo(new Cuerpo("Cuerpo 1", 99999, 99999));
        System.out.println(cuerpos.toString());
        
        cuerpos.cambiarTamaño(3);
        cuerpos.setValueAt(2, "Cuerpo 3", 99999, 99999);
        System.out.println(cuerpos.toString());
    }
}
