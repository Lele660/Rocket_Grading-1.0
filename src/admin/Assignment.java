/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author lelezhao
 */

/*
attributes:
assignment type;
assignment name;
assignment description;
assianment weight;
*/
public class Assignment {
    private String type;
    private String name;
    private String description;
    private int weight;
    
    public Assignment(String type, String name,String description, int weight){
        this.setType(type);
        this.setName(name);
        this.setDescription(description);
        this.setWeight(weight);
    }
    
    public void setType(String type){
        this.type = type;
    }
    public void setName(String name){
        this.name= name;
        
    }
    public void setDescription(String des){
        this.description = des;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public String getType(){
        return this.type;
    }
    public String getName(){
        return this.name;
    
    }
    public String getDescription(){
        return this.description;
    }
    public int getWeight(){
        return this.weight;
    }
    
}
