package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.beans.Pic;
import cn.uc.yiqibang.utils.Result;

public interface PicDao {
	
	Result deletePic(Pic pic);
	
	Result insertSelective(Pic pic);
	
}