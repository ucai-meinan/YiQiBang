package cn.uc.yiqibang.dao;


import cn.uc.yiqibang.beans.Comment;
import cn.uc.yiqibang.utils.Result;

public interface CommentDao {
	// <!-- ��ȡ�������� -->
	Result getAllComments();
	//<!-- ��������id��ȡ�����б�-->
	//<!-- �޸����� -->
	//<!-- ɾ������ -->
	Result deleteComm(Comment comm);
	//<!-- ����һ������-->
}
