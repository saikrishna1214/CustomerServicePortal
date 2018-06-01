package org.imaginea.requesttracking.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {
	
		 
	    private static HikariConfig config = new HikariConfig();
	    private static HikariDataSource ds;
	 
	    static {
	        config.setJdbcUrl( "jdbc_url" );
	        config.setUsername( "database_username" );
	        config.setPassword( "database_password" );
	        config.addDataSourceProperty( "cachePrepStmts" , "true" );
	        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
	        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
	        ds = new HikariDataSource( config );
	    }
	 
	    private DataSource() {}
	 
	    public static Connection getConnection() throws SQLException {
	        return (Connection) ds.getConnection();
	    }

}
