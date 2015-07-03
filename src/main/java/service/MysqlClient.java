package service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/6/10.
 */
@Service("mysqlClient")
public class MysqlClient {
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 数据库增删改，参数为对象数组
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object[] args) {
//        logger.debug("sql:{},args:{}", sql, args);
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 数据库增加后返回主键
     * @param preparedStatementCreator
     * @return
     */
    public int insertAndGetKey(PreparedStatementCreator preparedStatementCreator) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }


    /**
     * 数据库查询，返回结果集List
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> queryForList(String sql, Object[] args) {
        return jdbcTemplate.queryForList(sql, args);
    }

    /**
     * 数据库查询，返回结果集Map
     * @param sql
     * @param args
     * @return
     */
    public Map<String, Object> queryForMap(String sql, Object[] args) {
        Map<String, Object> resultMap = null;
        try {
            resultMap = jdbcTemplate.queryForMap(sql, args);
        } catch (EmptyResultDataAccessException e) {
            resultMap = new HashMap<String, Object>();
        }
        return resultMap;
    }
    public Map<String, Object> queryForMap(String sql) {
        Map<String, Object> resultMap = null;
        try {
            resultMap = jdbcTemplate.queryForMap(sql);
        } catch (EmptyResultDataAccessException e) {
            resultMap = new HashMap<String, Object>();
        }
        return resultMap;
    }

    /**
     * 数据库查询，返回原生结果集list<map>
     * @param sql
     * @return
     */
    public List queryList(String sql) {
        return jdbcTemplate.queryForList(sql);
    }
}
