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
     * ���ݿ���ɾ�ģ�����Ϊ��������
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object[] args) {
//        logger.debug("sql:{},args:{}", sql, args);
        return jdbcTemplate.update(sql, args);
    }

    /**
     * ���ݿ����Ӻ󷵻�����
     * @param preparedStatementCreator
     * @return
     */
    public int insertAndGetKey(PreparedStatementCreator preparedStatementCreator) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }


    /**
     * ���ݿ��ѯ�����ؽ����List
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> queryForList(String sql, Object[] args) {
        return jdbcTemplate.queryForList(sql, args);
    }

    /**
     * ���ݿ��ѯ�����ؽ����Map
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
     * ���ݿ��ѯ������ԭ�������list<map>
     * @param sql
     * @param objects
     * @return
     */
    public List queryList(String sql, Object[] objects) {
        return jdbcTemplate.queryForList(sql);
    }
}
