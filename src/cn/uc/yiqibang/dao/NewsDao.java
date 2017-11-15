package cn.uc.yiqibang.dao;

import javax.servlet.http.HttpServletRequest;

import cn.uc.yiqibang.beans.News;
import cn.uc.yiqibang.utils.Result;



public interface NewsDao {
	// ��������
	Result insertNews(News news);
	
	// ɾ������
	Result deleteNews(int newsid);
	
	// �޸�����---�޸��������� �޸��Ķ����� �޸�����
	Result updateCommNum(int newsid,int num);
	
	Result updateViewCount(int newsid,int count);
	
	Result updateNews(News news);
	
	// �޸�����ͼƬ
	Result updateNewsPic(int newsid,int picId,HttpServletRequest request);

	// ��ѯ����---��ѯ���� ���ݷ���id��ȡ���� ��������id��ȡһ����������
	Result selectAllNewsCount();
	
	Result selectAllNews();

//	Result selectLimitAllNews(Pagination page);
	
	Result selectNewsByTypeId(int typeId);
	
	Result selectNewsById(int newsid);
	
//	Result selectLimitNewsByCatId(int catId,Pagination page);
	
	// �����û�������Ϣģ����ѯ�����б�
	Result selectNewsByLike(String likeStr);
	
	// �ϴ�����ͼƬ
	Result addNewsPic(HttpServletRequest request);
}