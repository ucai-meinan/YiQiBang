package cn.uc.yiqibang.utils;

/**
 * �ַ����Ĳ���ƴ����
 * @author 12644
 *
 */
public class Constants {

	//��Ӧ��
	public static final int RETCODE_SUCCESS=0;
	public static final int RETCODE_FAILED=2000;
	
	//����ӳ���ļ�.xml�İ��ĸ�·��
	 public static final String root="cn.uc.yiqibang.mapper";
	 //����mapperӳ���ļ�������
	 public static final String commentMapper=".CommentMapper";
	 public static final String newsMapper=".NewsMapper";
	 public static final String PicMapper=".PicMapper";
	 public static final String typeMapper=".TypeMapper";
	 
	 //���������sql����id����
	 public static final String selectAllNews=".selectAllNews";	 
	 public static final String selectAllComm=".selectAllComm";	 
	 public static final String deletePic=".deletePic";
	 public static final String deleteComm=".deleteComm";
	 public static final String deleteNews=".deleteNews";
	 public static final String selectTypeById=".selectTypeById";
	 public static final String selectNewsByLike=".selectNewsByLike";
	 public static final String insertSelective=".insertSelective";
	 public static final String selectAllType=".selectAllType";
	 public static final String insertNews=".insertNews";
	 public static final String  updateNews=".updateNews";
	 //...
	 
	 //Comment���۵Ĳ������·��
	 public static final String commentMapper_selectAllComm=root+commentMapper+selectAllComm;
	 public static final String commentMapper_deleteComm=root+commentMapper+deleteComm;
	 
	 //News���ŵĲ������·��
	 public static final String newsMapper_selectAllNews=root+newsMapper+selectAllNews;
	 public static final String newsMapper_deleteNews=root+newsMapper+deleteNews;
	 public static final String newsMapper_selectByLike=root+newsMapper+selectNewsByLike;
	 public static final String newsMapper_insertNews=root+newsMapper+insertNews;
	 public static final String newsMapper_updateNews=root+newsMapper+updateNews;
	 
	 
	 //ͼƬ
	 public static final String picMapper_deletePic=root+PicMapper+deletePic;
	 public static final String picMapper_insertSelective=root+PicMapper+insertSelective;
	 
	 //��������	 
	 public static final String typeMapper_selectTypeById=root+typeMapper+selectTypeById;
	 public static final String typeMapper_selectAllType=root+typeMapper+selectAllType;
	
}
