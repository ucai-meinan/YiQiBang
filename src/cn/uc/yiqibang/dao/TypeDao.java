package cn.uc.yiqibang.dao;


import cn.uc.yiqibang.utils.Result;

public interface TypeDao {


    /**
     * 根据id查找类型详情
     * @param id
     * @return
     */
    Result selectTypeById(int id);
    
    Result selectAllType();

   
}