
package sat;

import java.text.SimpleDateFormat;
//import java.util.Date;
//import javafx.scene.input.DataFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Mladen
 */
public class sat 
{
   

    public sat() {
        Thread t=new Thread()
        {
            public void run()
            {
                while(true)
                {
                   DateFormat date=new SimpleDateFormat("hh:mm:ss");
                   
                   String datestring=date.format(new Date()).toString();            
                   
                   
                   
                   try
                   {
                       Thread.sleep(1);
                   }
                   catch(Exception e)
                   {
                       
                   }
                }
            }
            
        };
        t.start();  
    }

    
    
    
}
