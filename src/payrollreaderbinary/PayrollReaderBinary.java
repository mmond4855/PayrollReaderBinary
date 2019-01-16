
package payrollreaderbinary;

import dao.LineSequential;

import java.io.*;

public class PayrollReaderBinary 
{

    
    public static void main(String[] args) 
    {
       String inFile = "C:/Users/55mondelmd09/Documents/PayrollReaderBinary/PayrollMasterBinary.dat";
       String outFile = "C:/Users/55mondelmd09/Documents/PayrollReaderBinary/PayrollMaster.dat";
       String outFileStreamName = "payrollMasterA";
       
       byte [] byteArray = new byte[80];
       
       String outputLine;
       
       try (FileInputStream inFileStream  = new FileInputStream(inFile);)
       {
           LineSequential.open(outFile, outFileStreamName, "output");
           
           while(inFileStream.available() > 0)
               //while bytes are available.
           {
               inFileStream.read(byteArray);
               outputLine = new String(byteArray);
               
               LineSequential.write(outFileStreamName, outputLine);
               //Writes out at least 80 bytes.
           }
           
           LineSequential.close(outFileStreamName, "output");
           System.out.println("File is complete. ");
       }
       catch(FileNotFoundException e)
       {
           System.out.println(e.getMessage());
       }
       catch (IOException e)
       {
           System.out.println(e.getMessage());
       }
    }
    
}
