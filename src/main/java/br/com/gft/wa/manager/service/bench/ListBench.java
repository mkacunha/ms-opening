package br.com.gft.wa.manager.service.bench;

import br.com.gft.wa.manager.instrastructure.file.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ListBench {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ListBench(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bench> list(String filter) {
        List<BenchResultSet> list = findBench();
        Map<Bench, List<BenchResultSet>> benchMap = groupByEmployee(list);
        List<Bench> bench = mapToBench(benchMap);
        return applyFilter(filter, bench);
    }


    private List<BenchResultSet> findBench() {
        String sql = FileReader.readAsString("sql/benchSqlList.sql");
        return jdbcTemplate.query(sql, new BenchRowMapper());
    }

    private Map<Bench, List<BenchResultSet>> groupByEmployee(List<BenchResultSet> list) {
        Map<Bench, List<BenchResultSet>> benchMap = list.stream().collect(Collectors.groupingBy(BenchResultSet::toBench));
        return benchMap;
    }

    private List<Bench> mapToBench(Map<Bench, List<BenchResultSet>> benchMap) {
        return benchMap.entrySet().stream().map(entry -> {
            entry.getKey().applySkillAndLanguage(entry.getValue());
            return entry.getKey();
        }).collect(Collectors.toList());
    }

    private List<Bench> applyFilter(String filter, List<Bench> list) {
        if (StringUtils.hasText(filter)) {
            return list.stream().filter(value -> value.test(filter)).collect(Collectors.toList());
        }
        return list;
    }
}
