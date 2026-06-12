package gui;

import java.util.*;
public class Polygon {
	protected int test=10;
    int x=0;
    int y=0;    
    private static int count = 0;
    
    public Polygon(){
        Scanner scan = new Scanner(System.in);
        System.out.println("input x :");
        x = scan.nextInt();
        System.out.println("input y :");
        y = scan.nextInt();
        count++;
    }
    public Polygon(int x, int y){
        this.x = x;
        this.y = y;
        count++;
    }
    public void disp() {
    	;
    }
    
    public String getX() {
    	String strX = x+""; //+",";
    	return strX;
    }
    
    public String getY() {
    	String strX = y+"" ; // +",";
    	return strX;
    }
    
    public int getCount() {
        return count;
    }
}

 

class Circle extends Polygon {
    int radius;
    static int count_cir=1;
    private int index;
    private String result;
   // private int x;
   // private int y;
    
    public Circle() {
        super ();
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("input Radius :");
        radius = scan.nextInt();

        index =  count_cir++; 
 

    }    
    Circle(int x, int y, int r) {
        super(x,y);
        this.radius = r;
        index =  count_cir++; 
        super.x = x;
    }
    
    public void disp() {
        //count_cir++;
        System.out.println("Circle " + index +"------------"+"\n"+"\t"
                +"Center point is "+"("+getX()+","+getY()+")"+"\n"+"\t"
                +"Radius is "+radius+"\n");
    }
    public String toString() {
        //count_cir++;
        String rst = "Circle " + index +"------------"+"\n"+"\t"
                +"Center point is "+"("+getX()+","+getY()+")"+"\n"+"\t"
                +"Radius is "+radius+"\n";
        return rst;
    }
}

 

class Rectangle extends Polygon {
    int width, height;
    private static int count_rec=1;
    private int index;
    private String result;
    
    public enum Gender{ 
    	M,
    	F;
    }
    public Gender g;
    
    Rectangle(int x, int y, int w, int h){
        super(x,y);

        
        index =  count_rec++; 
        this.width = w;
        this.height = h;
        g= Gender.valueOf("M");
       // if(g == Gender.M) System.out.println(g);
    }
    Rectangle(){
    	
        super();
        Scanner scan = new Scanner(System.in);
        System.out.println("input width :");
        width = scan.nextInt();
        System.out.println("input height :");
        height = scan.nextInt();
        index =  count_rec++; 
    }
  
    public void disp() {
//        //count_rec++;
//        System.out.println("Rectangle " + index +"------------"+"\n"+"\t"
//    +"Left-TOP corner point is "+"("+super.getX()+","+y+")"+"\n"+"\t"
//    +"Width: "+width+"\n"+"\t"
//    +"Height: "+height+"\n");
        System.out.println("Rectangle " + index +"------------"+"\n"+"\t"
        	    +"Left-TOP corner point is "+"("+super.getX()+","+super.getY()+")"+"\n"+"\t"
        	    +"Width: "+width+"\n"+"\t"
        	    +"Height: "+height+"\n");
    }
}