package bankingdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn() {
        try {
           
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hrpass");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


