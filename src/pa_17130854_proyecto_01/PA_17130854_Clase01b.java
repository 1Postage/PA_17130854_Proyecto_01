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
class ArrayCuerpo {

    private Cuerpo[] cuerpos;

    public ArrayCuerpo() {
        cuerpos = new Cuerpo[0];
    }

    public ArrayCuerpo(int tamaño) {
        if (tamaño > 0) {
            cuerpos = new Cuerpo[tamaño];
        }
    }

    public ArrayCuerpo(Cuerpo[] arrCuerpos) {
        cuerpos = arrCuerpos.clone();
    }

    public void cambiarTamaño(int tamaño) {
        Cuerpo[] nuevoTamaño = new Cuerpo[tamaño];
        
        // el tamaño se expande
        if (tamaño > cuerpos.length) {
            // copiar datos al nuevo arreglo si se expande
            for (int i = 0; i < cuerpos.length; i++) {
                if(cuerpos[i]!= null)
                    nuevoTamaño[i] = cuerpos[i];
            }
         
        }else if( tamaño < cuerpos.length) { // el tamaño decrece
            for (int i = 0; i < tamaño; i++) {
                if(cuerpos[i]!= null)
                    nuevoTamaño[i] = cuerpos[i];
            }
        }else {
            // salir si no cambia el tamaño
            return;
        }

        // copiar el nuevo arreglo a la variable principal
        cuerpos = nuevoTamaño.clone();
    }

    // añadir un cuerpo al primer espacio vacio del arreglo
    public void addCuerpo(Cuerpo cuerpo) {
        // recorrer el arreglo buscando el espacio vacío
        for (int i = 0; i < cuerpos.length; i++) {
            System.out.println("" + cuerpos[i]);
            if (cuerpos[i] == null) {
                cuerpos[i] = new Cuerpo(cuerpo.getNombre(), cuerpo.getVelocidad(), cuerpo.getEnergia());
                System.out.println("ADDED");
                break;
            }
        }
        
    }

    public void setValueAt(int index, String nombre, double velocidad, double energia) {
        if (cuerpos.length > index && index >= 0) {
            cuerpos[index] = new Cuerpo(nombre, velocidad, energia);
        }
    }

    public void setCuerpoAt(int index, Cuerpo cuerpo) {
        if (cuerpos.length > index && index >= 0) {
            cuerpos[index] = cuerpo;
        }
    }

    public Cuerpo getCuerpoAt(int index) {
        if (index >= 0 && index < cuerpos.length && cuerpos != null) {
            return cuerpos[index];
        }
        return null;
    }

    public int getTamaño() {
        return cuerpos.length;
    }

    public boolean isEmpty() {
        if (cuerpos == null) {
            return true;
        }
        if (cuerpos.length == 0) {
            return true;
        }
        return false;
    }
    
    public Cuerpo mayorMasa() {
        Cuerpo cuerpoMayorMasa = new Cuerpo();
        for (int i = 0; i < cuerpos.length; i++) {
            if(cuerpos[i].calcularMasa()> cuerpoMayorMasa.calcularMasa()) 
            {
                cuerpoMayorMasa = cuerpos[i];
            }
        }
        return cuerpoMayorMasa;
    }
    
     public Cuerpo menorMasa() {
        Cuerpo cuerpoMenorMasa = cuerpos[0];
        for (int i = 0; i < cuerpos.length; i++) {
            if(cuerpos[i].calcularMasa() < cuerpoMenorMasa.calcularMasa()) 
            {
                cuerpoMenorMasa = cuerpos[i];
            }
        }
        return cuerpoMenorMasa;
    }

    // ordenamientos de forma ascendente 
    public void ordenEnergia() {
        
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getEnergia() < cuerpos[j].getEnergia()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }

    public void ordenVelocidad() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getVelocidad() < cuerpos[j].getVelocidad()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }

    public void ordenarMasa() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getMasa() < cuerpos[j].getMasa()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }
    
    public void ordenarAlfabetico() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if(cuerpos[i]!= null && cuerpos[j] != null)
                if (cuerpos[i].getNombre().compareTo(cuerpos[j].getNombre()) > 0) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }
    
    // ordenamientos de forma descendente 
    
    public void ordenarAlfabeticoDesc() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if(cuerpos[i]!= null && cuerpos[j] != null)
                if (cuerpos[i].getNombre().compareTo(cuerpos[j].getNombre()) < 0) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }
    
    
    public void ordenEnergiaDesc() {
        
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getEnergia() > cuerpos[j].getEnergia()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }

    public void ordenVelocidadDesc() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getVelocidad() > cuerpos[j].getVelocidad()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }

    public void ordenarMasaDesc() {
        for (int i = 0; i < cuerpos.length -1 ; i++) {
            for (int j = i + 1; j < cuerpos.length; j++) {
                if (cuerpos[i].getMasa() > cuerpos[j].getMasa()) {
                    Cuerpo aux = cuerpos[i];
                    cuerpos[i] = cuerpos[j];
                    cuerpos[j] = aux;
                }
            }
        }
    }

    

    public String toString() {
        String str = "";
        for (int i = 0; i < cuerpos.length; i++) {
            if (cuerpos[i] != null) {
                str += "Nombre: " + cuerpos[i].getNombre() + ", Masa: " + cuerpos[i].calcularMasa() + "\n";
            } else {
                str += "Null element at index: " + i + "\n";
            }
        }
        return str;
    }
}
