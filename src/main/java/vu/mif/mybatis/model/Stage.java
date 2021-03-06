package vu.mif.mybatis.model;

import java.util.Date;

public class Stage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STAGE.ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STAGE.ENDDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    private Date enddate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STAGE.NAME
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STAGE.STARTDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    private Date startdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STAGE.PROJECT_ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    private Integer projectId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STAGE.ID
     *
     * @return the value of PUBLIC.STAGE.ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STAGE.ID
     *
     * @param id the value for PUBLIC.STAGE.ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STAGE.ENDDATE
     *
     * @return the value of PUBLIC.STAGE.ENDDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STAGE.ENDDATE
     *
     * @param enddate the value for PUBLIC.STAGE.ENDDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STAGE.NAME
     *
     * @return the value of PUBLIC.STAGE.NAME
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STAGE.NAME
     *
     * @param name the value for PUBLIC.STAGE.NAME
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STAGE.STARTDATE
     *
     * @return the value of PUBLIC.STAGE.STARTDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STAGE.STARTDATE
     *
     * @param startdate the value for PUBLIC.STAGE.STARTDATE
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STAGE.PROJECT_ID
     *
     * @return the value of PUBLIC.STAGE.PROJECT_ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STAGE.PROJECT_ID
     *
     * @param projectId the value for PUBLIC.STAGE.PROJECT_ID
     *
     * @mbg.generated Sun Apr 21 21:43:32 EEST 2019
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    private Project project;

    public void setProject(Project project) {this.project = project; }
    public Project getProject() { return this.project; }
}