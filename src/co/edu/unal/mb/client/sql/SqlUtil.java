package co.edu.unal.mb.client.sql;

import java.sql.ResultSet;
import java.sql.Statement;

public class SqlUtil
{
    private SqlUtil( 
    	final String sDbSvrIp, final String sDbSvrPort,
        final String sDbUser, final String sDbUpwd, 
        final String sDbSchema ) {
    	
        m_db = new SQLDatabase( sDbSvrIp, sDbSvrPort, sDbUser, sDbUpwd, sDbSchema );
    }

    public synchronized static SqlUtil createInstance(
    	final String sDbSvrIp, final String sDbSvrPort,
        final String sDbUser, final String sDbUpwd, 
        final String sDbSchema ) {

    	if ( m_this == null ) {
    	
    		m_this = new SqlUtil(
    			sDbSvrIp, sDbSvrPort, sDbUser, sDbUpwd, sDbSchema );
    	}
    	
        return m_this;
    }

    public static SqlUtil getInstance() {
    	
    	return m_this;
    }
    
    public ResultSet query( Object obj )
    {	
        ResultSet rs = null;

        if ( obj != null && obj.toString() != null )
        {
            Statement st = null;
            
            try
            {
                st = m_db.getStatement();
                if ( st != null )
                {
                    rs = st.executeQuery( obj.toString() );
                }
            }
            catch ( Exception exc )
            {
                System.out.println( "Error at [ SqlService::query() ] --> " + exc );
                System.out.println( "Error at [ SqlService::query() ] sentence="+obj.toString() );

                if ( st != null )
                {
                    try
                    {
                        st.close();
                    }	
                    catch ( Exception cexc )
                    {
                        System.out.println( "Error at [ SqlService::query() ] st.close() --> " + cexc );
                    }
                }
            }
        }
        
        return rs;
        
    } 	// query

    public int execute( Object obj )
    {
        int nResult = FAILED;
        
        if ( obj != null && obj.toString() != null )
        {
            Statement st = null;
            
            try
            {
                st = m_db.getStatement();
                if ( st != null )
                {
                    nResult = st.executeUpdate( obj.toString() );
                }
            }
            catch ( Exception exc )
            {
                System.out.println( "Error at [ SqlService::execute() ] --> " + exc );
                System.out.println( "Error at [ SqlService::execute() ] sentence="+obj.toString() );

                if ( st != null )
                {
                    try
                    {
                        st.close();
                    }	
                    catch ( Exception cexc )
                    {
                        System.out.println( "Error at [ SqlService::execute() ] st.close() --> " + cexc );
                    }
                }
            }
        }
        
        return nResult;
        
    } 	// execute
/*
    static public void main( String[] args ) {
    	
        String szTestTable = "user";
        String szTestAccnt = "user";
        String szTesPasswd = "pswd";
        
        SqlService su = SqlService.createInstance(
        		"localhost", "3306", "ISII", "IPWD", "test" );
        
        ResultSet rs = su.query( "SELECT * FROM " + szTestTable );
        try
        {
            while ( rs.next() )
            {
                System.out.println( rs.getString( szTestAccnt ) + 
                                    "=" + 
                                    rs.getString( szTesPasswd ) );
            }
        }
        catch ( Exception exc )
        {
        }
    }*/

    public boolean isValid()
    {
        return (m_db != null && m_db.isValid());
    }
    
    private static SqlUtil m_this = null;
    
    // no database pool
    private SQLDatabase m_db;
    
    public static final int FAILED = -1;	
}

