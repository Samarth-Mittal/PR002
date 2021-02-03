import model.colours.*;
import model.items.*;

import java.util.*;

public class Colour_Game {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        Set<Items> list=new HashSet<>();
        String s=sc.nextLine();
        while(!s.equals("exit")){
            if(s.charAt(0)=='+'){
                try {
                    Items item = getItem(s.substring(1));
                    item.subscribes();
                    list.add(item);
                }catch (Exception e){
                    System.out.println("Item not present.");
                }
            }else if(s.charAt(0)=='-'){
                try {
                    Items item = getItem(s.substring(1));
                    item.unsubscribes();
                    list.remove(item);
                }catch (Exception e){
                    System.out.println("Item not present.");
                }
            }else if(s.equals("list")){
                System.out.print("[");
                for(Items items: list){
                    System.out.print(items.getClass().getSimpleName()+", ");
                }
                if(list.size()!=0){
                    System.out.print("\b\b");
                }
                System.out.println("]");
            }else{
                try{
                    Colour colour=getColour(s);
                    colour.post();
                }catch (Exception e){
                    System.out.println("Colour not present.");
                }
            }
            s=sc.nextLine();
        }
    }

    private static Colour getColour(String s) throws Exception {
        if(s.equals("black")){
            return Black.getInstance();
        }else if(s.equals("blue")){
            return Blue.getInstance();
        }else if(s.equals("green")){
            return Green.getInstance();
        }else if(s.equals("red")){
            return Red.getInstance();
        }else if(s.equals("white")){
            return White.getInstance();
        }else if(s.equals("yellow")){
            return Yellow.getInstance();
        }else{
            throw new Exception();
        }
    }

    private static Items getItem(String s) throws Exception {
        if(s.equals("apple")){
            return Apple.getInstance();
        }else if(s.equals("banana")){
            return Banana.getInstance();
        }else if(s.equals("blood")){
            return Blood.getInstance();
        }else if(s.equals("frog")){
            return Frog.getInstance();
        }else if(s.equals("ink")){
            return Ink.getInstance();
        }else if(s.equals("salt")){
            return Salt.getInstance();
        }else if(s.equals("sky")){
            return Sky.getInstance();
        }else{
            throw new Exception();
        }
    }
}


