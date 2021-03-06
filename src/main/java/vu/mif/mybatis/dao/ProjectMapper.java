package vu.mif.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.mif.mybatis.model.Project;

@Mapper
public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PROJECT
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PROJECT
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PROJECT
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    Project selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PROJECT
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    List<Project> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PROJECT
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    int updateByPrimaryKey(Project record);
}