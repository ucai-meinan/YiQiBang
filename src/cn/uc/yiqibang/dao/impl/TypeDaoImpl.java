package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import cn.uc.yiqibang.beans.Type;
import cn.uc.yiqibang.dao.TypeDao;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class TypeDaoImpl implements TypeDao {

	

	@Override
	public Result selectTypeById(int id) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		Type type = session.selectOne(Constants.typeMapper_selectTypeById,id);
		session.close();
		if(type!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(type);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}
	
	@Override
	public Result selectAllType() {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		List<Type> types = session.selectList(Constants.typeMapper_selectAllType);
		session.close();
		if(types!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(types);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

//	public static void main(String[] args) {
//		
//		Result type=new TypeDaoImpl().selectAllType();
//		System.out.println(type.getRetData());	
//	}

}
