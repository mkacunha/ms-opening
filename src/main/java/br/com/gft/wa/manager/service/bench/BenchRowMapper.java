package br.com.gft.wa.manager.service.bench;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class BenchRowMapper implements RowMapper<BenchResultSet> {

    @Override
    public BenchResultSet mapRow(ResultSet resultSet, int i) throws SQLException {
        var bench = new BenchResultSet();
        bench.name = resultSet.getString("name");
        bench.id = resultSet.getString("id");
        bench.status = resultSet.getString("status");
        bench.family = resultSet.getString("family");
        bench.level = resultSet.getString("level");
        bench.city = resultSet.getString("city");
        bench.location = resultSet.getString("location");
        bench.skill = resultSet.getString("skill");
        bench.skillLevel = resultSet.getString("skill_level");
        bench.language = resultSet.getString("language");
        bench.languageLevel = resultSet.getString("language_level");
        return bench;
    }
}