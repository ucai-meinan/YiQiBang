package cn.uc.yiqibang.dao;


import cn.uc.yiqibang.utils.Result;

public interface TypeDao {


    /**
     * ����id������������
     * @param id
     * @return
     */
    Result selectTypeById(int id);
    
    Result selectAllType();

   
}