package vu.mif.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.mif.mybatis.model.Stage;

@Mapper
public interface StageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int insert(Stage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    Stage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    List<Stage> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int updateByPrimaryKey(Stage record);
}