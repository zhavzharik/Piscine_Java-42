package edu.school21.sockets.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(HikariDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(Integer id) {
        return jdbcTemplate.query("SELECT * FROM public.users WHERE id = ?", new Object[]{id.intValue()}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM public.users", (rs, rowNum) -> new User(rs.getInt(1), rs.getString(2)));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("insert into public.users (id, email) VALUES (?, ?)", entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE public.users SET email = ? WHERE id = ?", entity.getEmail(), entity.getIdentifier());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM public.users WHERE id = ?", id.intValue());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(jdbcTemplate.query("SELECT * FROM public.users WHERE email = ?", new Object[]{email}, new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null));
    }
}
