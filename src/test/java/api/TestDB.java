package api;

import dao.ReceiptDao;
import org.h2.jdbcx.JdbcConnectionPool;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.hasSize;

public class TestDB {

    public static org.jooq.Configuration setupJooq() {
        // For now we are just going to use an H2 Database.  We'll upgrade to mysql later
        // This connection string tells H2 to initialize itself with our schema.sql before allowing connections
        final String jdbcUrl = "jdbc:h2:mem:test;MODE=MySQL;INIT=RUNSCRIPT from 'classpath:schema.sql'";
        JdbcConnectionPool cp = JdbcConnectionPool.create(jdbcUrl, "sa", "sa");

        // This sets up jooq to talk to whatever database we are using.
        org.jooq.Configuration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(SQLDialect.MYSQL);   // Lets stick to using MySQL (H2 is OK with this!)
        jooqConfig.set(cp);
        return jooqConfig;
    }

    @Test
    public void testInsertToDB() {
        org.jooq.Configuration jooqConfig = setupJooq();
        ReceiptDao receiptDao = new ReceiptDao(jooqConfig);
        int id = receiptDao.insert("ari", new BigDecimal(33.44));
        assertTrue(id == 1);

    }
}
