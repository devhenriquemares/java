package loja;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProjetoLojaSwing {

    public static void main(String[] args) {
        int prodCount = 0;
        
        //lista de produtos
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Integer> codProdList = new ArrayList<>();
        
        while(true){ 
            int escolha;
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "\n\t\tInsira o número correspondente ao campo em que deseja atuar: \n\n" +
                            "1.Adicionar produto\n2.Atualizar quantidade de produto\n3Exibir lista de produtos\n4.Sair\n"));
            
            switch (escolha){
                case 1:
                    Produto newProduct = new Produto();
                    newProduct.CadastrarProd(codProdList);
                    produtos.add(newProduct);
                    
                    prodCount++;
                    
                    break;
                case 2:
                    int codProd = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Insira o código do produto em que deseja atualizar a quantidade"));
                    
                    for(int i = 0; i < prodCount; i++){
                        if(!codProdList.contains(codProd)){
                            JOptionPane.showMessageDialog(null, "Produto inexistente...");
                            
                            break;
                        }
                        else if(codProdList.get(i) == codProd){
                            int valorAdd = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor que será acrescentado"));
                            int prodQuant = produtos.get(i).getQuantProd();
                            produtos.get(i).setQuantProd(prodQuant + valorAdd);
                        }
                    }
                    
                    break;
                case 3:
                    for(int i = 0; i < prodCount; i++){
                        produtos.get(i).ListarProd();
                        
                        int continuar = -1;
                        if(i < prodCount - 1){
                            continuar = JOptionPane.showConfirmDialog(null, "Deseja ver o próximo produto?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        }
                        
                        if(continuar == JOptionPane.NO_OPTION){
                            break;
                        }
                    }
                    
                    break;
                case 4:
                    System.exit(0);
            }
            
        }
    }
}