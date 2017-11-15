package cn.uc.yiqibang.dao.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.beans.Comment;
import cn.uc.yiqibang.beans.News;
import cn.uc.yiqibang.beans.Pic;
import cn.uc.yiqibang.dao.CommentDao;
import cn.uc.yiqibang.dao.NewsDao;
import cn.uc.yiqibang.dao.PicDao;

import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class NewsDaoImpl implements NewsDao {
	PicDao picDao = new PicDaoImpl();
	CommentDao commDao = new CommentDaoImpl();
	
	@Override
	public Result insertNews(News news) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
		// 添加新闻
		SqlSession session = MyBatisUtils.openSession();
		int row = session.insert(Constants.newsMapper_insertNews, news);
		session.commit();
		session.close();
		if (row > 0) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result deleteNews(int newsid) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);

		// 删除该id关联的所有图片
		Pic pic = new Pic();
		pic.setNewsId(newsid);
		picDao.deletePic(pic);

		// 删除该id关联的所有评论
		Comment comm = new Comment();
		comm.setNewsId(newsid);
		commDao.deleteComm(comm);

		// 删除新闻
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.newsMapper_deleteNews, newsid);
		session.commit();
		session.close();
		if (row > 0) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result updateCommNum(int newsid, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateViewCount(int newsid, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result updateNews(News news) {
		// TODO Auto-generated method stub
				Result result = new Result();
				result.setRetCode(Constants.RETCODE_FAILED);
				result.setRetMsg(false);
				// 添加新闻
				SqlSession session = MyBatisUtils.openSession();
				int row = session.insert(Constants.newsMapper_updateNews, news);
				session.commit();
				session.close();
				if (row > 0) {
					result.setRetCode(Constants.RETCODE_SUCCESS);
					result.setRetMsg(true);
				}
				return result;
	}

	@Override
	public Result updateNewsPic(int newsid, int picId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectAllNewsCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectAllNews() {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		List<News> newsList = session.selectList(Constants.newsMapper_selectAllNews);
		session.close();
		if(newsList!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(newsList);
			result.setRetMsg(true);
		}else{
			result.setRetMsg(false);
			result.setRetCode(Constants.RETCODE_FAILED);
		}
		return result;
	}

	@Override
	public Result selectNewsByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectNewsById(int newsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result selectNewsByLike(String likeStr) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
		// 添加新闻
		SqlSession session = MyBatisUtils.openSession();
		List<News> news = session.selectList(Constants.newsMapper_selectByLike, likeStr);
		session.close();
		if (news!=null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		
//		List<News> news =(List<News>) new NewsDaoImpl().selectNewsByLike("阿飞");
//		System.out.println(news);
//		
//	}
	
	@Override
	public Result addNewsPic(HttpServletRequest request) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
		// 创建磁盘工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("d:/"));
		factory.setSizeThreshold(100 * 1024 * 1024);

		// 创建文件上传工具对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(-1);// 上传的单个文件的大小 -1表示无限制
		upload.setHeaderEncoding("UTF-8");
		upload.setSizeMax(50 * 1024 * 1024);

		try {
			List<FileItem> files = upload.parseRequest(request);
			Iterator<FileItem> itFile = files.iterator();
			while (itFile.hasNext()) {
				FileItem file = itFile.next();
				if (!file.isFormField()) {
					String picName = file.getName();

					// 将图片的名称拼接为当前时间的毫秒数类型.后缀
					String suffix = picName.substring(picName.lastIndexOf("."));
					long currTime = System.currentTimeMillis();
					String imgName = currTime + suffix;

					String imgPath = request.getServletContext().getRealPath("new_imgs");
					File filePath = new File(imgPath);
					if (!filePath.exists()) {
						filePath.mkdirs();
					}
					String picPath = imgPath + File.separator + imgName;
					file.write(new File(picPath));

					Pic pic = new Pic();
					pic.setPath(imgName);
					result = picDao.insertSelective(pic);
					if(result.isRetMsg()){
						result.setRetData(imgName);
					}
					
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	
	
}
