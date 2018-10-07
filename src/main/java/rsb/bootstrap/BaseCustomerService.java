package rsb.bootstrap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BaseCustomerService implements CustomerService {

	protected abstract DataSource getDataSource();

	private final AtomicReference<JdbcTemplate> templateAtomicReference = new AtomicReference<>();

	private final RowMapper<Customer> rowMapper = (rs,
			i) -> new Customer(rs.getLong("id"), rs.getString("NAME"));

	private JdbcTemplate getJdbcTemplate() {
		if (this.templateAtomicReference.get() == null) {
			this.templateAtomicReference.set(new JdbcTemplate(getDataSource()));
		}
		return this.templateAtomicReference.get();
	}

	@Override
	public Customer save(String name) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.getJdbcTemplate().update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"insert into CUSTOMERS (name) values(?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			return ps;
		}, keyHolder);
		Long keyHolderKey = Objects.requireNonNull(keyHolder.getKey()).longValue();
		Customer customer = this.findById(keyHolderKey);
		Assert.notNull(name, "the name given must not be null");
		return customer;
	}

	@Override
	public Customer findById(Long id) {
		String sql = "select * from CUSTOMERS where id = ?";
		return this.getJdbcTemplate().queryForObject(sql, this.rowMapper, id);
	}

	@Override
	public Collection<Customer> findAll() {
		return this.getJdbcTemplate().query("select * from CUSTOMERS", rowMapper);
	}

}
