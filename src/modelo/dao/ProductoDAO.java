/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Producto;

/**
 *
 * @author COMPUTER
 */
public class ProductoDAO {
    private List<Producto> productos;
    
    public ProductoDAO(){
        productos = new ArrayList<>();
    }
    
    public int buscar(int codigo){
        int posicion = -1;
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getIdproducto() == codigo){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
    public boolean insertar(Producto producto)throws Exception{
        try{
            if(buscar(producto.getIdproducto())==-1){
                productos.add(producto);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean modificar(Producto producto)throws Exception{
        try{
            int posicion = buscar(producto.getIdproducto());
            if(posicion != -1){
                productos.set(posicion, producto);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean eliminar(int codigo)throws Exception{
        try{
            int posicion = buscar(codigo);
            if(posicion != -1){
                productos.remove(posicion);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Producto obtener(int codigo)throws Exception{
        try{
            int pos = buscar(codigo);
            return productos.get(pos);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public List<Producto> listar(){
        return productos;
    }
}
