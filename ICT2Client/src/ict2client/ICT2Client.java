/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict2client;

import server.Exception_Exception;

/**
 *
 * @author hp
 */
public class ICT2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICT2Client client = new ICT2Client();
        client.Execute();
    }
    public void Execute(){
        Double value1;
        Double value2;
        Double sum;
       if(testConnection() == 0)
       {
           System.out.println("[CLIENT] - Server is connected...");
           try{
               value1 = 5.0;
               value2= 6.0;
               System.out.println("[CLIENT] - Testing safeSum() method with value: "+value1 +" and "+value2);
               sum = safeSum(value1, value2);
               System.out.println("[CLIENT] - Sum of method of value = "+ value1 + " + "+ value2 + " = " +sum);
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - Testing safeSum() method");
           }
           
           
           try{
               value1 = 6.0;
               value2= null;
               System.out.println("[CLIENT] - Testing safeSum() method with value: "+value1 +" and "+value2);
               sum = safeSum(value1, value2);
               System.out.println("[CLIENT] - Sum of method of value = "+ value1 + " + "+ value2 + " = " +sum);
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - Sum not calculated. Null value detected...");
           }
           System.out.println("[CLIENT] ---------addStringOnServer & getLongestString-----------------------");
           String stringValue;
           String holderString;
           String longestString;
           try{
               stringValue = "Hi";
               
               System.out.println("[CLIENT] - Testing addStringOnServer() method with value: "+stringValue);
               holderString = addStringOnServer(stringValue);
               System.out.println("[CLIENT] - Has been successfuly added to the server");
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - null Input...");
           }
           try{
               stringValue = "Bye Fellow";
               
               System.out.println("[CLIENT] - Testing addStringOnServer() method with value: "+stringValue);
               holderString = addStringOnServer(stringValue);
               System.out.println("[CLIENT] - Has been successfuly added to the server");
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - null Input...");
           }
           try{
               stringValue = "Hi Sir!";
               
               System.out.println("[CLIENT] - Testing addStringOnServer() method with value: "+stringValue);
               holderString = addStringOnServer(stringValue);
               System.out.println("[CLIENT] - Has been successfuly added to the server");
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - null Input...");
           }
           try{
               stringValue = null;
               
               System.out.println("[CLIENT] - Testing addStringOnServer() method with value: "+stringValue);
               holderString = addStringOnServer(stringValue);
               System.out.println("[CLIENT] - Has been successfuly added to the server");
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - null Input...");
           }
           System.out.println("--------------------Longest String------------------------");
           try{
               longestString = getLongestString();
               System.out.println("[CLIENT] - Has been successful, longest string is: " +longestString);
               System.out.println();
           }catch(Exception_Exception ex){
               System.out.println("[CLIENT] - Array is empty");
           }
           System.out.println("[CLIENT] ---------getAllStringsShorterThan Question 7-----------------------");
           
           
           
          
           
           
           
       }
    }

    private static Integer testConnection() {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.testConnection();
    }

    private static Double safeSum(java.lang.Double d1, java.lang.Double d2) throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.safeSum(d1, d2);
    }

    private static String addStringOnServer(java.lang.String string) throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.addStringOnServer(string);
    }

    private static String getLongestString() throws Exception_Exception {
        server.ICT2WebService_Service service = new server.ICT2WebService_Service();
        server.ICT2WebService port = service.getICT2WebServicePort();
        return port.getLongestString();
    }

    
    
}
