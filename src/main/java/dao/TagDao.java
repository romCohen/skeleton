package dao;

import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.TAGS;

public class TagDao {

    DSLContext dsl;
    ReceiptDao receiptsDao;

    public TagDao(Configuration jooqConfig, ReceiptDao receipts) {
        this.receiptsDao = receipts;
        this.dsl = DSL.using(jooqConfig);
    }

    public void tagOrUntag(String tagName, int receiptId) {
        TagsRecord tagRecord = dsl.selectFrom(TAGS)
                .where(TAGS.TAG_NAME.eq(tagName))
                .and(TAGS.ID.eq(receiptId))
                .fetchOne();
        if (tagRecord == null) {
            // No tag for this receipt, add tag
            dsl.insertInto(TAGS, TAGS.TAG_NAME, TAGS.ID)
                    .values(tagName, receiptId)
                    .execute();
        } else {
            // remove tag
            dsl.deleteFrom(TAGS)
                    .where(TAGS.TAG_NAME.eq(tagName))
                    .and(TAGS.ID.eq(receiptId))
                    .execute();
        }
    }

    public List<ReceiptsRecord> getReceiptsFromTag(String tagName) {
        Result<Record1<Integer>> results = dsl
                .select(TAGS.ID)
                .from(TAGS)
                .where(TAGS.TAG_NAME.eq(tagName))
                .fetch();
        return receiptsDao.getReceipts(results);
    }

}
