/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.H645;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Empresa implements ITrabajadorManagement{
    private ArrayList<Trabajador> empleados;
    private String nombre;
    
    public Empresa(String n){
        nombre = n;
        empleados = new ArrayList<Trabajador>();
    }
    
    @Override
    public void agregarEmpleado(Trabajador t){
        empleados.add(t);
    }
    
    @Override
    public void imprimirPlanilla(){
        System.out.println("LISTA EMPLEADOS\n-----------");
        
        for(Trabajador tra : empleados){
            System.out.println(tra);
        }
    }
    
    @Override
    public boolean buscarTrabajador(int cod){
        Trabajador t = new Trabajador(cod, "") {

            @Override
            public double calcularPago() {
                return 0;
            }
        };
        
        return empleados.contains(t);
    }

    @Override
    public double pagarATrabajador(int cod) {
       for(int i=0;i<empleados.size();i++){
           if(cod==empleados.get(i).getCodigo())
               return empleados.get(i).calcularPago();
       
       }
        /*
         * TODO: Buscar dentro de la coleccion el empleado que
         * tenga el codigo que recibe de parametro. Y si se
         * encuentra se retorna el monto a pagar de dicho empleado.
         * Si no se retorna 0.
         */
        return 0;
    }

    @Override
    public void setHorasTrabajadas(int cod, int horast) {
        for(int i=0;i<empleados.size();i++){
            if(cod==empleados.get(i).getCodigo()){
                if(empleados.get(i)instanceof EmpleadoPorHora){
                   empleados.get(i);
                }
            }
        }
        /*
         * TODO: Busca un empleado dentro de la coleccion con ese
         * codigo que recibe de parametro. Si se encuentra se valida
         * que sea de tipo EmpleadoPorHora. SI LO ES se actualiza sus
         * horas trabajadas segun el parametro horasT
         */
    }

    @Override
    public void setVentas(int cod, double ventas) {
        for(int i=0;i<empleados.size();i++){
            if(cod==empleados.get(i).getCodigo()){
                if(empleados.get(i)instanceof EmpleadoPorVenta){
                    
                }
            }
        }
        /*
         * TODO: Busca un empleado dentro de la coleccion con ese
         * codigo que recibe de parametro. Si se encuentra se valida
         * que sea de tipo EmpleadoPorVenta. SI LO ES se actualiza su
         * venta mensual segun el parametro
         */
    }

    @Override
    public void setFechaNacimiento(int cod, Date fecha) {
        for(int i=0;i<empleados.size();i++){
            if(cod==empleados.get(i).getCodigo()){
                empleados.get(i).setFechanac(fecha);
            }
        /*
         * TODO: Busca el empleado. Y si existe se le actualiza
         * su fecha de nacimiento.
         */
        }
    }

    @Override
    public void setIHSS(int cod, int valor) {
        for(int i=0;i<empleados.size();i++){
            if(cod==empleados.get(i).getCodigo()){
                empleados.get(i).setIhss(valor);
            }
        }
    }

    @Override
    public void setTipoJerarquia(int cod, TipoJerarquia tipo) {
        for(int i=0;i<empleados.size();i++){
            if(cod==empleados.get(i).getCodigo()){
                empleados.get(i).setTipo(tipo);
            }
        }
    }

    @Override
    public Trabajador longevo() {
        Trabajador temp= empleados.get(0);
        int año = 2012;
        for(int i=0;i<empleados.size();i++){
            if(año>empleados.get(i).getFechanac().getYear()){
                temp=empleados.get(i);
            }
        }
        return temp;
    }
    
}
