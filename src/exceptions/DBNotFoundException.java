package exceptions;


import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;

import java.sql.SQLException;

public class DBNotFoundException extends SQLException {

    public DBNotFoundException() {}

    public DBNotFoundException(String message){
        super(message);
    }

}
