package loja;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Produto {
    //variaveis
    private String nameProd;
    private int codProd;
    private int quantProd;
    
    //construtor vazio
    public Produto(){
        this("", 0, 0);
    }
    //construtor com parametros
    public Produto(String nameProd, int codProd, int quantProd){
        this.nameProd = nameProd;
        this.codProd = codProd;
        this.quantProd = quantProd;
    }
    
    //getters and setters
    public String getNameProd(){
        return this.nameProd;
    }
    public void setNameProd(String nameProd){
        this.nameProd = nameProd;
    }
    
    public int getCodProd(){
        return this.codProd;
    }
    public void setCodProd(int codProd){
        this.codProd = codProd;
    }
    
    public int getQuantProd(){
        return this.quantProd;
    }
    public void setQuantProd(int quantProd){
        this.quantProd = quantProd;
    }
    
    //verifica produtos
    public boolean Verificacao(ArrayList<Integer> array, int codProd){
        return !array.contains(codProd);
    }
    
    //cadastrar produtos
    public void CadastrarProd(ArrayList<Integer> array){
        //verificação do codigo
        boolean repetir;
        do{
            repetir = false;
            
            this.setCodProd(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto")));
            
            if(!Verificacao(array, this.getCodProd())){
                JOptionPane.showMessageDialog(null, "Produto já existente...");
                repetir = true;
            }
            else{
                array.add(this.getCodProd());
            }
            
        }while(repetir == true);
        
        this.setQuantProd(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade do produto")));
        
        this.setNameProd(JOptionPane.showInputDialog(null, "Digite o nome do produto"));
    }
    
    //listar produtos
    public void ListarProd(){
        JOptionPane.showMessageDialog(null,
                "\t\t" + this.getNameProd() +
                "\nCódigo: " + this.getCodProd() +
                "\nQuantidade: " + this.getQuantProd() + "\n\n",
                this.getClass().getName(), 1);
    }
}