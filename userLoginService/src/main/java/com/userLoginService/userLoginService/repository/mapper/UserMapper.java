package com.userLoginService.userLoginService.repository.mapper;

import com.userLoginService.userLoginService.model.CustomUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<CustomUser> {
    @Override
    public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomUser(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("roles"),
                rs.getString("permissions")
        );
    }
}
