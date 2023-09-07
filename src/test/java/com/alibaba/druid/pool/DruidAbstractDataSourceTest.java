package com.alibaba.druid.pool;

import junit.framework.TestCase;

public class DruidAbstractDataSourceTest extends TestCase {
    private DruidDataSource dataSource;

    protected void setUp() throws Exception {

        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@a.b.c.d:1521:testconn");
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(14);
        dataSource.setMaxIdle(14);
        dataSource.setMinIdle(1);
        dataSource.setMinEvictableIdleTimeMillis(300 * 1000); // 300 / 10
        dataSource.setTimeBetweenEvictionRunsMillis(180 * 1000); // 180 / 10
        dataSource.setTestWhileIdle(false);
        dataSource.setTestOnBorrow(false);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setFilters("stat");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setUsername("alibaba");
        dataSource.setPassword("alibaba");
    }
    public void testGetDynamicTimeBetweenConnectErrorMillis() {

        for (int errorCount = 1500000; errorCount < 1500010; errorCount++) {
           long time= dataSource.getDynamicTimeBetweenConnectErrorMillis(errorCount);
            System.out.println("errorCount : "+ errorCount+" ,TimeBetweenConnectErrorMillis : " + time);
        }
    }
}