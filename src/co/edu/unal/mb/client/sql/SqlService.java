package co.edu.unal.mb.client.sql;

public class SqlService {
	
	static String szDbSvrIp   = "localhost";
    static String szDbSvrPort = "3306";
    static String szDbUser    = "root";
    static String szDbUpwd    = "root";
    static String szDbSchema  = "mb";
  
    static SqlUtil db = SqlUtil.createInstance(szDbSvrIp, szDbSvrPort, szDbUser, szDbUpwd, szDbSchema);
    
    public static SqlUtil getDB(){
    	return db;
    }
    
}
