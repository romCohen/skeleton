/**
 * This class is generated by jOOQ
 */
package generated.tables.records;


import generated.tables.Tags;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagsRecord extends UpdatableRecordImpl<TagsRecord> implements Record2<String, Integer> {

	private static final long serialVersionUID = -230836507;

	/**
	 * Setter for <code>public.tags.tag_name</code>.
	 */
	public void setTagName(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.tags.tag_name</code>.
	 */
	public String getTagName() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>public.tags.id</code>.
	 */
	public void setId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.tags.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record2<String, Integer> key() {
		return (Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, Integer> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, Integer> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return Tags.TAGS.TAG_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Tags.TAGS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getTagName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value1(String value) {
		setTagName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value2(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord values(String value1, Integer value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TagsRecord
	 */
	public TagsRecord() {
		super(Tags.TAGS);
	}

	/**
	 * Create a detached, initialised TagsRecord
	 */
	public TagsRecord(String tagName, Integer id) {
		super(Tags.TAGS);

		setValue(0, tagName);
		setValue(1, id);
	}
}
