/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Leticia
 */
public class BinaryTree {
    
    int valor, aux=0;
    String conc;
    BinaryTree noEsquerda, noDireita;
    
    public BinaryTree(int valor) {
        this.valor = valor;
    }
    public static BinaryTree raiz;
    
    public String ordem2(BinaryTree node) {
       if (node != null) {
            ordem2(node.noEsquerda);
            //System.out.print( node.valor + ", ");
            conc += (node.valor) + " ";
            ordem2(node.noDireita);
       }
        return conc;
    }
    
    public String inserir(BinaryTree node, int valor) {
        if (node == null) {
            System.out.println("Root " + valor);
            raiz = new BinaryTree(valor);
            return ("Root " + valor);
        } 
        else {
            if (valor < node.valor) {
                if (node.noEsquerda != null) {
                    inserir(node.noEsquerda, valor);
                } else {
                    System.out.println("Inserting " + valor + " on the left of " + node.valor);
                    node.noEsquerda = new BinaryTree(valor);
                    return ("Inserting " + valor + " on the left of " + node.valor);
                }
            } else {
                if (node.noDireita != null) {
                    inserir(node.noDireita, valor);
                } else {
                    System.out.println("Inserting " + valor + " on the right of " + node.valor);
                    node.noDireita = new BinaryTree(valor);
                    return ("Inserting " + valor + " on the right of " + node.valor);
                }
            }
        }
        return ordem2(raiz);
    }

    public String procurar(BinaryTree node, int valor){
        if(node==null)
            return ("this number is not in the tree!");
        else if(valor<node.valor)
            procurar(node.noEsquerda, valor);
        else if(valor>node.valor)
            procurar(node.noDireita, valor);
        else
            return ("This number is in the tree!");
        return "0";
    }
    
    public String valabaixocima(BinaryTree node, int valor) {
        if (node != null) {
        if(valor<node.valor){
            aux = node.valor;
            
            valabaixocima(node.noEsquerda, valor);
        }
        else if(valor>node.valor){
            aux = node.valor;
            valabaixocima(node.noDireita, valor);
        }
        else{
            if(node.noDireita==null && node.noEsquerda==null){
            return ("node right: null node left: null node previous: " + aux);
            }
            else if(node.noEsquerda==null){
                return ("node right: " + (node.noDireita).valor + "  node left: null  node previous: " + aux);
            }
            else if(node.noDireita==null){
                return ("node right: null node left: "+ (node.noEsquerda).valor +" node previous: " + aux);
            }
            else
            return ("node right: " + (node.noDireita).valor + "  node left: " + (node.noEsquerda).valor
            + "  node previous: " + aux);
        }
        }
        return "0";
    }
    
    private BinaryTree removeMinimo(BinaryTree node) {  
        if (node == null) {  
            System.out.println("  ERROR ");  
        } else if (node.noEsquerda != null) {  
            node.noEsquerda=(removeMinimo(node.noEsquerda));  
            return node;  
        } else {  
            return node.noDireita;  
        }  
        return null;  
    }  
  
    private BinaryTree encontraMinimo(BinaryTree node) {  
        if (node != null) {  
            while (node.noEsquerda != null) {  
                node = node.noEsquerda;  
            }  
        }  
        return node;  
    }
            
    public BinaryTree remover(BinaryTree node, int valor) throws Exception {
        if(node == null){
            throw new Exception("Empty Tree");
        } else {            
            if(valor < node.valor){
                node.noEsquerda=(remover(node.noEsquerda,valor));
            } else if(valor > node.valor){
                node.noDireita=(remover(node.noDireita, valor));
            } else if (node.noEsquerda != null && node.noDireita != null) {
                /*2 filhos*/  
                //System.out.println("  Delete No " + node.valor);
                ordem2(raiz);
                node.valor=(encontraMinimo(node.noDireita).valor);
                node.noDireita=(removeMinimo(node.noDireita));
            } else {  
                //System.out.println("  Delete No " + node.valor);
                ordem2(raiz);
                node = (node.noEsquerda != null) ? node.noEsquerda : node.noDireita;  
            }  
            return node;
        }
    }
}
