package mybatis.dao;

import java.util.List;
import mybatis.model.Set;
import org.mybatis.cdi.Mapper;

@Mapper
public interface SetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SET
     *
     * @mbg.generated Wed Apr 06 17:07:41 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SET
     *
     * @mbg.generated Wed Apr 06 17:07:41 EEST 2022
     */
    int insert(Set record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SET
     *
     * @mbg.generated Wed Apr 06 17:07:41 EEST 2022
     */
    Set selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SET
     *
     * @mbg.generated Wed Apr 06 17:07:41 EEST 2022
     */
    List<Set> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SET
     *
     * @mbg.generated Wed Apr 06 17:07:41 EEST 2022
     */
    int updateByPrimaryKey(Set record);
}