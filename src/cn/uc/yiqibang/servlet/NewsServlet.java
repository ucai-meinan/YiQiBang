package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.beans.News;
import cn.uc.yiqibang.dao.NewsDao;
import cn.uc.yiqibang.dao.impl.NewsDaoImpl;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;
import net.sf.json.JSONObject;

@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	NewsDao newsDao = new NewsDaoImpl();

	public void adminSelectAllNews(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("请求获取所有xinwen");
		Result result = newsDao.selectAllNews();

		System.out.println("-----------------------" + result);
		String jsonObj = JSONObject.fromObject(result).toString();
		try {
			response.getWriter().println(jsonObj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void adminDeleteNewsById(HttpServletRequest request, HttpServletResponse response) {

		int newsid = Integer.parseInt(request.getParameter("id"));
		Result result = newsDao.deleteNews(newsid);
		WriteResultToClient.writeMethod(result, response);

	}

	public void adminGetNewsByLike(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("aaaaaaaaaaa");
		String likeStr = request.getParameter("likeStr");
		Result result = newsDao.selectNewsByLike("%" + likeStr + "%");
		WriteResultToClient.writeMethod(result, response);
	}

	public void adminInsertNews(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String source = request.getParameter("source");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String editorValue = request.getParameter("editorValue");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		boolean ifHot = Boolean.parseBoolean(request.getParameter("ifHot"));

		News news = new News();
		news.setAuthor(author);
		news.setContent(editorValue);
		news.setCreatetime(new Date());
		news.setIfHot(ifHot);
		news.setSource(source);
		news.setTitle(title);
		news.setContent(content);
		news.setTypeId(typeId);
		Result result = newsDao.insertNews(news);
		WriteResultToClient.writeMethod(result, response);
	}

	public void adminUpdateNews(HttpServletRequest request, HttpServletResponse response) {
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		News news = new News();
		news.setId(newsid);
		news.setAuthor(request.getParameter("author"));
		news.setContent(request.getParameter("content"));
		news.setIfHot(Boolean.parseBoolean(request.getParameter("ifHot")));
		news.setSource(request.getParameter("source"));
		news.setTypeId(Integer.parseInt(request.getParameter("typeId")));
		news.setTitle(request.getParameter("title"));
		news.setContent(request.getParameter("editorValue"));
		Result result = newsDao.insertNews(news);
		WriteResultToClient.writeMethod(result, response);

	}

}