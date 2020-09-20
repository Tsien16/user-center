package com.tsien.usercenter.dao.user;

import com.tsien.usercenter.domain.model.user.BonusEventLog;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2020/9/12 0012 0:22
 */
    

public interface BonusEventLogMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(BonusEventLog record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BonusEventLog record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    BonusEventLog selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BonusEventLog record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BonusEventLog record);
}