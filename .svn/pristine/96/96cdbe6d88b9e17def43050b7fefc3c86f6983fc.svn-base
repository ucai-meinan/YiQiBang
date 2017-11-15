package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.Comment;
import cn.uc.yiqibang.dao.CommentDao;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;



public class CommentDaoImpl implements CommentDao{

	@Override
	public Result getAllComments() {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		List<Comment> commentList = session.selectList(Constants.commentMapper_selectAllComm);
		session.close();
		if(commentList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(commentList);
			result.setRetMsg(true);
		}else{
			result.setRetMsg(false);
			result.setRetCode(Constants.RETCODE_FAILED);
		}
		return result;
	}

	@Override
	public Result deleteComm(Comment comm) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.commentMapper_deleteComm,comm);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

}
