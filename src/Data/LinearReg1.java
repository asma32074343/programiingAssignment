
package Data;


 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * this is our main class
 */
public class LinearReg1 {

   
   
    static ArrayList<Property> inputList = new ArrayList();

    /**
     here import the file that conatains our data
    
     */
    public static void main(String[] args) throws FileNotFoundException {
    inputList = readDataLineByLine("Data1/AssementData.csv");
    calculate(inputList);
    
    }
    
    
    
    static ArrayList<Property> readDataLineByLine(String file) throws FileNotFoundException 
{ 
    
    Scanner fileinput = new Scanner(new BufferedReader(new FileReader(file)));
   System.out.println("test");
    ArrayList<Property> data = new ArrayList(); 
    while (fileinput.hasNextLine()) {
        Property toAdd = new Property();
        String newline = fileinput.nextLine();

        String[] line = newline.trim().split(",");
     
 toAdd.setPrice(Double.parseDouble(line[4]));
 toAdd.setAddress(Double.parseDouble(line[9]));
 toAdd.setSm(Double.parseDouble(line[13]));
 data.add(toAdd);
 //here we relate the colun that we will use them from the data to the proprety that we create
 
    } 
        return data;
}
 ////////////////////////////the sum of Area
    //we put the area in  an objective of array that we sum the array
    static ArrayList<Double> calculate(ArrayList<Property> data){
      
    double sumx = 0;
       
        for (int i = 0; i <data.size();i++) {
            
            
            
            
            sumx += data.get(i).getSm();
         

        }
        sumx++;
   
  
 ///////////////////////////the sum of price
   //we put the price in  an objective of array that we sum the array
   double sumy = 0;
         for (int i = 0; i <data.size();i++) {
            sumy += data.get(i).price;
        }
              sumy++;
 /////////////////////////the square of price
 //here we sum the squar value of eatch index of the array of the price
          double tempy = 0;
        for (int i = 0; i < data.size(); i++)
        {
            tempy = tempy + Math.pow(data.get(i).price, 2);
        }
        tempy++;
  //////////////////////////the square of Are
   //here we sum the squar value of eatch index of the array of the area
    double tempx = 0;
        for (int i = 0; i < data.size(); i++)
        {
            tempx= tempx + Math.pow(data.get(i).sm, 2);
        }
         tempx++;
    
 ////////////////////////////////////////////////////////////           /
//this is is the number of elemant that we have
 double n=data.size();
//c is the square of sum of the area 
 double c=Math.pow(sumx, 2);
 ////////////////////////////////////////////////////area*price
   ArrayList<Double> mult = new ArrayList<Double>();
  //creat an empty araay list 
   double sum = 0;
        for(int i=0 ; i<data.size() ; i++) {
        sum = sum +(data.get(i).price*data.get(i).sm);        
}
 //we multiply the to array object of price and array  
 
       
      
     
          System.out.println("sum: "+sum);
//we sum the resut array
///////////////////////////////////////////////// 
//theis is the slop rule 
double A=(((sumy*tempx)-(sumx*sum))/(n*tempx-c)); 
//this is the coffecient rule
double B=((n*sum-(sumx*sumy))/(n*tempx-c));
//creat an array to transfer on it an the value of A and B to the user interface.
ArrayList<Double> lineqr = new ArrayList();
lineqr.add(A);
lineqr.add(B);
System.out.println(A);
System.out.println(B);
return lineqr;

}}
 




