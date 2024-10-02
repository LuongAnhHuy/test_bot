package Trivio.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ExecuteDatabase {
    ArrayList<String> getInformationInDB();
}
