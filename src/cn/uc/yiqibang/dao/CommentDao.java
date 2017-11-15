package cn.uc.yiqibang.dao;


import cn.uc.yiqibang.beans.Comment;
import cn.uc.yiqibang.utils.Result;

public interface CommentDao {
	// <!-- 获取所有评论 -->
	Result getAllComments();
	//<!-- 根据新闻id获取评论列表-->
	//<!-- 修改评论 -->
	//<!-- 删除评论 -->
	Result deleteComm(Comment comm);
	//<!-- 插入一条评论-->
}
