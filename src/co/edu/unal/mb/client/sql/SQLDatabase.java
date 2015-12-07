package co.edu.unal.mb.client.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SQLDatabase {
	
    public SQLDatabase( 
    	final String sDbSvrIp, final String sDbSvrPort,
    	final String sDbUser, final String sDbUpwd,
    	final String sSchema ) {
    	
        String sDbSrc = DB_PROTO_MYSQL + "://" 
        		+ sDbSvrIp + ":" + sDbSvrPort + "/" + sSchema;

        connect_pool( sDbSrc, sDbUser, sDbUpwd );
    }
    
    protected void connect_pool( 
	    	final String sDbSrc,
	        final String sDbUser, final String sDbUpwd ) {
    	
    	pool = new MysqlDataSource();
    	pool.setURL(sDbSrc);
    	pool.setUser(sDbUser);
    	pool.setPassword(sDbUpwd);
    }
    
    public Statement getStatement() {
        Statement st = null;
        
        try
        {
        	m_cConn = pool.getConnection();
            if ( m_cConn != null )
            {
                st = m_cConn.createStatement();
            }
        }
        catch ( Exception exc )
        {
            System.out.println( "Error on [ ExDatabase::getStatement() ] --> " + exc );
        }

        return st;
        
    }
    
    public boolean isValid() {
    	
        return m_bIsValid;
        
    }

    static public void main( String[] args ) {
    	
        String szDbSvrIp   = "localhost";
        String szDbSvrPort = "3306";
        String szDbUser    = "root";
        String szDbUpwd    = "root";
        String szDbSchema  = "mb";
        
        SQLDatabase db = new SQLDatabase( 
        	szDbSvrIp, szDbSvrPort, szDbUser, szDbUpwd, szDbSchema );
        
        Statement st = null;
        
        try
        {
            st = db.getStatement();
            if ( st != null )
            {
//              st.execute("DELETE FROM user WHERE user='Valeria'");
//            	st.execute("INSERT INTO user VALUES ('Lina', '9999')");
//            	st.execute("UPDATE user SET pswd='7777' WHERE user='Lina'");
                ResultSet rs = st.executeQuery( "SELECT * FROM login" );
//                ResultSet rs = st.executeQuery( "SELECT * FROM user" );
//            	ResultSet rs = st.executeQuery( "SELECT * FROM role" );
                
                while ( rs.next() ) {
                	
                	System.out.println( rs.getString(1)+", " + rs.getString(2)+", " + rs.getString(3)+", " + rs.getString(4) );
//                	System.out.println( rs.getString(1)+", " + rs.getString(2) );
                }
            }
        }
        catch ( Exception exc )
        {
            System.out.println( "Error at [ MySQLDatabase::main() ] --> " + exc );
        }
        finally
        {
            if ( st != null )
            {
                try
                {
                    st.close();
                }	
                catch ( Exception exc )
                {
                    System.out.println( "Error at [ MySQLDatabase::query() ] st.close() --> " + exc );
                }
            }
        }
    }

    // no connection pool
    protected Connection m_cConn;
    protected MysqlDataSource pool;
    
    protected boolean m_bIsValid;

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_PROTO_MYSQL = "jdbc:mysql";
    
}

