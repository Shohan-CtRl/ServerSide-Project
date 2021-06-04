/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hp
 */
@WebService(serviceName = "ICT2WebService")
public class ICT2WebService {
    ArrayList<String> stringValue = new ArrayList();
    ArrayList<String> shortestStringArray = new ArrayList();

    /**
     * Web service operation
        return testConnection;
     * @return 
     */
    @WebMethod(operationName = "testConnection")
    public Integer testConnection() {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "safeSum")
    public Double safeSum(@WebParam(name = "d1") Double d1, @WebParam(name = "d2") Double d2) throws Exception {
        //TODO write your implementation code here:
        if(d1 == null || d2 == null)
        {
            throw new Exception();
        }
        
        Double sum = d2 + d1;
        return sum;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addStringOnServer")
    public String addStringOnServer(@WebParam(name = "String") String String) throws Exception {
        if(String == null)
        {
            throw new Exception();
        }
        System.out.println("[SERVER] - adding " + String + " to " + stringValue);
        stringValue.add(String);
        System.out.println("[SERVER] - Now values are " +  stringValue);
        return String;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLongestString")
    public String getLongestString() throws Exception {
        if (stringValue.isEmpty())
        {
            throw new Exception();
        }
        String max = stringValue.get(0);
        for(int i = 0; i < stringValue.size(); i++)
        {
            if(stringValue.get(i).length() > max.length())
            {
                max = stringValue.get(i);
            }
            
        }
                
        return max;
    }

    /**
     * Web service operation
     * @param Integer
     */
    @WebMethod(operationName = "getAllStringsShorterThan")
    public ArrayList getAllStringsShorterThan(@WebParam(name = "Integer") Integer Integer) throws Exception {
        if (stringValue.isEmpty())
        {
            throw new Exception();
        }
        String min = stringValue.get(0);
        for(int i = -1; i < stringValue.size(); i++)
        {
            if(stringValue.get(i).length() < Integer)
            {
                min = stringValue.get(i);
                shortestStringArray.add(min);
            }
            
        }
        return shortestStringArray;
    }




}
