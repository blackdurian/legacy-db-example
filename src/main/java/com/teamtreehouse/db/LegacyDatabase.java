package com.teamtreehouse.db;

import java.io.IOException;


public class LegacyDatabase implements AutoCloseable {
  private String dbString;
  private Connection conn;

  public LegacyDatabase(String dbString) {
    System.out.println("LegacyDatabase::new was called");
    this.dbString = dbString;
    conn = new Connection();
  }

  public static LegacyDatabase fromConfig() {
    // This comes from an injected config in reality...sssh
    return new LegacyDatabase("foxpro://192.168.0.1");
  }

  public Connection getConnection() {
    return conn;
  }


  @Override
  public void close() throws Exception {
    cleanUp();
  }

  public void cleanUp() throws IOException {
    System.out.println("LegacyDatabase::cleanUp called");
    conn.close();

  }


}

